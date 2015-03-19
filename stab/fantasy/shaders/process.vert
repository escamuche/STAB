

varying vec2 offsets[9];
 
void main() {
   gl_TexCoord[0] = gl_MultiTexCoord0;
   gl_Position = gl_ModelViewProjectionMatrix * gl_Vertex;
   
   float f=0.006;
 
    offsets[ 0] = vec2(-f, -f);
    offsets[ 1] =  vec2(0.0, -f);
    offsets[ 2] = vec2(f,-f);
    offsets[ 3] = vec2(-f, 0.0);
    offsets[ 4] = vec2(0.0, 0.0);
    offsets[ 5] = vec2(f, 0.0);
    offsets[ 6] = vec2(-f, f);
    offsets[ 7] = vec2( 0.0, f);
    offsets[ 8] =  vec2( f, f);
  
}
