

varying vec2 offsets[9];
uniform vec2 resolution;
 
void main() {
   gl_TexCoord[0] = gl_MultiTexCoord0;
   gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
   
   
    float ox;
 	float oy;
 	ox=1/resolution.x;
 	oy=1/resolution.y;
 
    offsets[ 0] = vec2(-ox, -oy);
    offsets[ 1] =  vec2(0.0, -oy);
    offsets[ 2] = vec2(ox,-oy);
    offsets[ 3] = vec2(-ox, 0.0);
    offsets[ 4] = vec2(0.0, 0.0);
    offsets[ 5] = vec2(ox, 0.0);
    offsets[ 6] = vec2(-ox, oy);
    offsets[ 7] = vec2( 0.0, oy);
    offsets[ 8] =  vec2( ox, oy);
  
}
