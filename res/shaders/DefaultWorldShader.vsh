#version 400 core

#define M_PI 3.1415926535897932384626433832795

in vec3 position;
in vec2 texCoord;

out vec2 texCoordPass;
out vec3 posPass;

out float visibility;

uniform mat4 transformationMatrix;
uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

uniform float fogDensity;
uniform float fogGradient;

uniform float time;

const float theta = -90 * M_PI / 180;
const mat2 textureRotMatrix = mat2(
		cos(theta), -sin(theta),
		sin(theta), cos(theta)
	);

void main() {
	vec4 worldPosition = transformationMatrix * vec4(position, 1.0);
	vec4 positionRelativeToCam = viewMatrix * worldPosition;
	gl_Position = projectionMatrix * positionRelativeToCam;
	
	float distanceFromCam = length(positionRelativeToCam.xyz);
	visibility = exp(-pow((distanceFromCam*fogDensity), fogGradient));
	visibility = clamp(visibility, 0.0, 1.0);
	
	float time2 = time * 2;	
	
	texCoordPass = texCoord * textureRotMatrix;// * vec2(cos(time), sin(time));
	posPass = position;
}