// Simple Water shader. (c) Victor Korsun, bitekas@gmail.com; 2012.
//
// Attribution-ShareAlike CC License.

#ifdef GL_ES
precision highp float;
#endif

const float PI = 3.1415926535897932;

// play with these parameters to custimize the effect
// ===================================================

//speed
const float speed = 0.01;
const float speed_x = 0.3;
const float speed_y = 0.3;

// refraction
const float emboss = 0.47;
const float intensity = 5.4;
const int steps = 8;
const float frequency = 1.0;
const int angle = 7; // better when a prime

// reflection
const float delta = 60.;
const float intence = 700.;

// ===================================================



uniform float time;
uniform vec2 resolution;
uniform sampler2D s_texture;

  float col(vec2 coord)
  {
 	 float time2 = time / 1.5;
    float delta_theta = 2.0 * PI / float(angle);
    float col = 0.0;
    float theta = 0.0;
    for (int i = 0; i < steps; i++)
    {
      vec2 adjc = coord;
      theta = delta_theta*float(i);
      adjc.x += cos(theta)*time2*speed + time2 * speed_x;
      adjc.y -= sin(theta)*time2*speed - time2 * speed_y;
      col = col + cos( (adjc.x*cos(theta) - adjc.y*sin(theta))*frequency)*intensity;
    }

    return cos(col);
  }

//---------- main

void main(void)
{
	//vec2 p = (gl_FragCoord.xy) / iResolution.xy, c1 = p, c2 = p;
	vec2 p = gl_TexCoord[0].st;
	vec2 c1=p , c2=p;
	
	float cc1 = col(c1);

	c2.x += resolution.x/delta;
	float dx = emboss*(cc1-col(c2))/delta;

	c2.x = p.x;
	c2.y += resolution.y/delta;
	float dy = emboss*(cc1-col(c2))/delta;

	c1.x += dx;
	c1.y = -(c1.y+dy);

	float alpha = 1.+dot(dx,dy)*intence;
	vec4 col = texture2D(s_texture,c1)*(alpha);
	gl_FragColor = col;
}
