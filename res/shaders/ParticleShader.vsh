#version 400 core

in vec2 position;
in vec2 texCoord;

in mat4 modelViewMatrix;

in vec4 offset;
in float texCoordScale;
in float blendValue;

out vec2 texCoordPass1;
out vec2 texCoordPass2;
out float blendValuePass;

uniform mat4 projectionMatrix;

void main() {
	vec4 clacl = projectionMatrix * modelViewMatrix * vec4(position, 0, 1.0);
	gl_Position = vec4(position, 0, 1); //projectionMatrix * modelViewMatrix * vec4(position, 0, 1.0);
	
	texCoordPass1 = (texCoord / texCoordScale) + offset.xy;
	texCoordPass2 = (texCoord / texCoordScale) + offset.zw;
	
	blendValuePass = blendValue;
}