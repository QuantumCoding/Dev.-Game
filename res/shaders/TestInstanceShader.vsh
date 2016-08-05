#version 400 core

in vec3 position;
in vec2 texCoord;
in vec3 normal;

in vec3 color;
in mat4 offset;

out vec3 colorOff;
out vec2 texCoordPass;
out vec3 surfaceNormal;

uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

void main(void) {
	vec4 worldPosition = offset * vec4(position, 1.0);
	vec4 positionRelativeToCam = viewMatrix * worldPosition;
	gl_Position = projectionMatrix * positionRelativeToCam;

	
	texCoordPass = texCoord;
	surfaceNormal = (offset * vec4(normal, 0)).xyz;
	colorOff = color;
}