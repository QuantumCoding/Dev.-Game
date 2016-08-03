#version 400 core

in vec2 texCoordPass1;
in vec2 texCoordPass2;

in float blendValuePass;

out vec4 outColor;

uniform sampler2D texture0;

void main() {
	vec4 textureSample1 = texture(texture0, texCoordPass1);
	vec4 textureSample2 = texture(texture0, texCoordPass2);
	vec4 ummmm = mix(textureSample1, textureSample2, blendValuePass);
	
	outColor = mix(textureSample1, textureSample2, blendValuePass);
}