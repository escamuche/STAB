#ifdef GL_ES
precision mediump float;
#endif
	
uniform float time;
uniform vec2 resolution;
uniform sampler2D s_texture;

void main(void)
{

	vec2 pos = gl_TexCoord[0].st;
	float i= pos.y *25 + time*25;
	float amp= 0.03;
	
	// Create the wiggle
	float d = (sin(i)*amp) ;
	
	
	
	pos.x += d;
	
	vec4 col = texture2D(s_texture,pos);
	gl_FragColor = col;
	
}