#version 400 core

in vec2 texCoordPass;
in vec3 posPass;

in float visibility;

out vec4 outColor;

uniform sampler2D texture0;

uniform vec3 skyColor;

void main() {
	vec4 colorTextureSample = texture(texture0, texCoordPass);
	
	outColor = colorTextureSample;//vec4(posPass / 5 / 5, 1); //
	//outColor = vec4(1, (texCoordPass * 255 - vec2(64, 15)) / 16, 1); //
	outColor = mix(vec4(skyColor, 1.0), outColor, visibility);
	
	//outColor = vec4(1, 0, 0, 1);
}