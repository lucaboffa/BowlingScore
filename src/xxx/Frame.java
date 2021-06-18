package xxx;

public class Frame {

    private int roll1 = -1;
    private int roll2 = -1;
    private int rollBonus = -1;
    private FrameType frameType = null;
    

    
    public Frame() {
    	frameType = FrameType.NORMAL;
    }
    
    
    
    public int getRoll1() {
		return roll1;
	}

    public void setRoll1(int roll1) {
		this.roll1 = roll1;
	}

	public int getRoll2() {
		return roll2;
	}
	public void setRoll2(int roll2) {
		this.roll2 = roll2;
	}

    public int getRollBonus() {
		return rollBonus;
	}
	public void setRollBonus(int rollBonus) {
		this.rollBonus = rollBonus;
	}



	public void setFrameType(FrameType type){
    	frameType = type;
    }
	
    public FrameType getFrameType(){
    	return frameType;
    }


	public enum FrameType {
		
		STRIKE(4), SPARE(3), NORMAL(2);  // 4,3,2 indica il numero di score da considerare nello stack per ciascuna tipologia di FRAME

        
        private final int value;
 	    
	    private FrameType(int value) {
	        this.value = value;
	    }  
	    public int getValue() {
	        return value;
	    }
    }
    
}
