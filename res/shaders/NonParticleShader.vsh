#version 140

in vec2 position;
in vec2 texCoord;

out vec2 textureCoord1;
out vec2 textureCoord2;
out float blend;

uniform mat4 projectionMatrix;
uniform mat4 modelViewMatrix;

uniform vec2 texOffset1;
uniform vec2 texOffset2;

uniform float textureDivisor;
uniform float blendFactor;

void main(void) {
	gl_Position = projectionMatrix * modelViewMatrix * vec4(position, 0.0, 1.0);
	
	textureCoord1 = (texCoord / textureDivisor) + texOffset1;
	textureCoord2 = (texCoord / textureDivisor) + texOffset2;
	blend = blendFactor;
}