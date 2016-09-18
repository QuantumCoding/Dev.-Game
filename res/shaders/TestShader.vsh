#version 330

in vec3 pos;
out vec3 colPos;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

void main() {
	vec4 worldPosition = transformationMatrix * vec4(pos, 1.0);
	vec4 positionRelativeToCam = viewMatrix * worldPosition;
	gl_Position = projectionMatrix * positionRelativeToCam;
	
	colPos = pos + 0.3;
}