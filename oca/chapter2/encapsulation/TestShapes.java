class GameShape {
	public void displayShape() {
		System.out.println("displaying shape");
	}
}

interface Animatable {
	public void animate();
}

class PlayerPiece extends GameShape implements Animatable {
	@Override
	public void animate() {
		System.out.println("animating player");
	}
	
	public void movePiece() {
		System.out.println("moving game piece");
	}
}

class TilePiece extends GameShape {
	public void getAdjacent() {
		System.out.println("getting adjacent tiles");
	}
}

public class TestShapes {
	public static void main(String[] args) {
		PlayerPiece shape = new PlayerPiece();
		TilePiece tile = new TilePiece();
		doShapes(shape);
		doShapes(tile);
		
		if (shape instanceof GameShape) {
			System.out.println("player is a game shape!");
		}
		
		if (shape instanceof Animatable) {
			System.out.println("player is animatable!");
		}
	}
	
	public static void doShapes(GameShape shape) {
		shape.displayShape();
	}
}
