class Program{

public static void main(String[] args)
{
try{
	java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
	float s1 = Float.parseFloat(in.readLine());
	float s2 = Float.parseFloat(in.readLine());
	float s3 = Float.parseFloat(in.readLine());
	System.out.println(square(s1,s2,s3));
}catch(java.lang.Exception ex)
{}
	
}
static float square(float s1, float s2, float s3)
{
	float p2=(s1+s2+s3)/2;
	return (float)java.lang.Math.sqrt(p2*(p2-s1)*(p2-s2)*(p2-s3));
}

}