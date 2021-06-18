package xxx;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import xxx.Frame.FrameType;

public class Player {

		//LISTA CON TUTTI I FRAMES
	 	private List<Frame> frames = null; 
	 	private int lastIndexFrame = 0;
	 	private int currentIndexFrame = 0;
	 	
	 	
	 	// STACK temporaneo utilizzato per calcolare gli scores dei vari frames
	 	private Stack<Integer> tmpStackScores = null; 
	 	
	 	//ARRAY DI TUTTI GLI SCORES DEL PLAYER
	 	private List<Integer> scores = new ArrayList<Integer>();
	 	private int indexScore = 0;
	 	private int totalScore = 0; // TOTALE DEL PUNTEGGIO AGGIORNATO AL FRAME IN ESAME
	 	
	 	
	 	
	    public Stack<Integer> getTmpStackScores() {
	    	if(tmpStackScores==null)
	    		tmpStackScores = new Stack<Integer>();
			return tmpStackScores;
		}
	    
		public void setTmpStackScores(Stack<Integer> tmpStackScores) {
			this.tmpStackScores = tmpStackScores;
		}
		

		
		//CARICAMENTO DELLO STACK CON GLI SCORES INERENTI AL FRAME IN ESAME
		public void loadTmpStackScores() {
			tmpStackScores.clear();			
			
			switch (getFrames().get(getLastIndexFrame()).getFrameType()) {
				case STRIKE:
					for(int i=getLastIndexFrame()*2; i < scores.size(); i++){
						if(getTmpStackScores().size() < FrameType.STRIKE.getValue())
							tmpStackScores.push(scores.get(i));
					}	
					break;
				case SPARE:
					for(int i=getLastIndexFrame()*2; i < scores.size(); i++){	
						if(getTmpStackScores().size() < FrameType.SPARE.getValue())
							tmpStackScores.push(scores.get(i));
					}	
					break;
				default:
					for(int i=getLastIndexFrame()*2; i < scores.size(); i++){						
						if(getTmpStackScores().size() < FrameType.NORMAL.getValue())
							tmpStackScores.push(scores.get(i));
					}
					break;
			}
				
	    }
		
		
		
		public int getIndexScore() {
			return indexScore;
		}
		public void setIndexScore(int indexScore) {
			this.indexScore = indexScore;
		}
	

		

		public void addScore(Integer score) {
			if(indexScore<21){				
				this.getScores().add(score);
				indexScore++;
			}	
		}	
		
		public List<Integer> getScores() {
			return scores;
		}
		public void setScores(List<Integer> scores) {
			this.scores = scores;
		}
		
		
		public List<Frame> getFrames() {
			if(frames==null)
				frames = new ArrayList<Frame>();
			return frames;
		}
		
		public void addFrame(Frame frame) {
			if(frames==null)
				frames = new ArrayList<Frame>();
	        frames.add(frame);
	    }

	    
	    
	    public void addCurrentIndexFrame() {
	    	currentIndexFrame++;
	    }
		public int getCurrentIndexFrame() {
			return currentIndexFrame;
		}
		
	    public void addLastIndexFrame() {
	    	lastIndexFrame++;
	    }
		public int getLastIndexFrame() {
			return lastIndexFrame;
		}


		
		public int getTotalScore() {
			return totalScore;
		}
		public void setTotalScore(int totalScore) {
			this.totalScore = totalScore;
		}
	    public void addTotalScore(int currentScore) {
	    	this.totalScore = totalScore+currentScore;
	    }
	
}
