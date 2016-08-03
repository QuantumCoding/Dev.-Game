#version 400 core

in vec2 texCoordPass;

out float fragmentdepth;
out vec4 color_out;
 
uniform sampler2D texture0;
 
void main(){
    // Not really needed, OpenGL does it anyway
    fragmentdepth = gl_FragCoord.z;
	color_out = texture(texture0, texCoordPass);
}