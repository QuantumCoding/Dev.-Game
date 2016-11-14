#version 400 core

in vec3 position;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

uniform vec3 globalTranslation;
uniform vec3 globalRotation;
uniform vec3 globalScale;

vec3 rotate(vec3 pos, vec3 rot) {
	float x = pos.x;
	float y = pos.y;
	float z = pos.z;
	
	float _11 = cos(rot.y) * cos(rot.z);
	float _12 = cos(rot.z) * sin(rot.x) * sin(rot.y) - cos(rot.x) * sin(rot.z);
	float _13 = cos(rot.x) * cos(rot.z) * sin(rot.y) + sin(rot.x) * sin(rot.z);
	
	float _21 = cos(rot.y) * sin(rot.z);
	float _22 = cos(rot.x) * cos(rot.z) + sin(rot.x) * sin(rot.y) * sin(rot.z);
	float _23 = -cos(rot.z) * sin(rot.x) + cos(rot.x) * sin(rot.y) * sin(rot.z);
	
	float _31 = -sin(rot.y);
	float _32 = cos(rot.y) * sin(rot.x);
	float _33 = cos(rot.x) * cos(rot.y);
	
	return vec3(
			(x * (_22 * _33 - _23 * _32) + y * (_13 * _32 - _12 * _33) + z * (_12 * _23 - _13 * _22)),
			(x * (_23 * _31 - _21 * _33) + y * (_11 * _33 - _13 * _31) + z * (_13 * _21 - _11 * _23)),
			(x * (_21 * _32 - _22 * _31) + y * (_12 * _31 - _11 * _32) + z * (_11 * _22 - _12 * _21))
		);

	//return vec3((x * (cos(rot.y) * cos(rot.z)) + y * (cos(rot.z) * sin(rot.x) * sin(rot.y) - cos(rot.x) * sin(rot.z)) + z * ( cos(rot.x) * cos(rot.z) * sin(rot.y) + sin(rot.x) * sin(rot.z))),
	//			(x * (cos(rot.y) * sin(rot.z)) + y * (cos(rot.x) * cos(rot.z) + sin(rot.x) * sin(rot.y) * sin(rot.z)) + z * (-cos(rot.z) * sin(rot.x) + cos(rot.x) * sin(rot.y) * sin(rot.z))),
	//			(x * (-sin(rot.y)) 			   + y * (cos(rot.y) * sin(rot.x)) 										  + z * (cos(rot.x) * cos(rot.y)))
	//);
}

void main() {
	vec3 localCenter = vec3(transformationMatrix[3][0], transformationMatrix[3][1], transformationMatrix[3][2]);
	vec3 globalPosition = (localCenter - globalTranslation) / globalScale;
	
	mat4 modifiedMatrix = transformationMatrix;
	modifiedMatrix[3] = vec4(globalPosition, 1);
	
	vec3 newPos = position / globalScale;
	
	vec4 worldPosition = vec4(rotate((modifiedMatrix * vec4(newPos, 1.0)).xyz, globalRotation), 1);
	vec4 positionRelativeToCam = viewMatrix * worldPosition;
	gl_Position = projectionMatrix * positionRelativeToCam;
}