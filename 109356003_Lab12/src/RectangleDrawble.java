
public class RectangleDrawble implements Drawble {

	private char marker;
	@Override
	public void setMarker(char marker) {
		// TODO Auto-generated method stub
		this.marker = marker;

	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		for(int i = 0 ; i <= 3 ; i++) {
			//印列
			for(int j = 0 ; j<=10 ; j++) {
				//印行				
				System.out.print(this.marker);
				
			}			
			System.out.println();
		}
	}

}
