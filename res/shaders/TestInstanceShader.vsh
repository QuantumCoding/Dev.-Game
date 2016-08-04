#version 400 core

in vec3 position;
in vec2 texCoord;
in vec3 normal;

in vec3 offset;

out vec2 texCoordPass;
out vec3 surfaceNormal;

uniform mat4 projectionMatrix;
uniform mat4 viewMatrix;

void main(void) {
	vec4 worldPosition = vec4(position + offset, 1.0);
	vec4 positionRelativeToCam = viewMatrix * worldPosition;
	gl_Position = projectionMatrix * positionRelativeToCam;

	
	texCoordPass = texCoord;
	surfaceNormal = normal + offset;
}