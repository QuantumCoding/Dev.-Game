#version 140

in vec2 position;
in vec2 texCoord;

in vec2 texOffset1;
in vec2 texOffset2;

in float textureDivisor;
in float blendFactor;

in mat4 modelViewMatrix;

out vec2 textureCoord1;
out vec2 textureCoord2;
out float blend;

uniform mat4 projectionMatrix;

void main(void) {
	gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 0.0, 1.0);
	
	textureCoord1 = (texCoord / textureDivisor) + texOffset1;
	textureCoord2 = (texCoord / textureDivisor) + texOffset2;
	blend = blendFactor;
}