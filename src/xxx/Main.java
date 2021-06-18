package xxx;

import java.util.Scanner;

import xxx.Frame.FrameType;

public class Main {

	public static void main(String[] args) {
		
		Scanner scanner = null;

		//SIMULAZIONE CON UN SOLO GIOCATORE
		Player player1 		 = new Player();
		Frame  currentFrame  = null;
		
		for (int i = 0; i <= 10; i++){
			
			currentFrame  = new Frame();
			
			if(!player1.getTmpStackScores().isEmpty()){
				calclulateScore(player1);
				System.out.println("[FRAME"+(player1.getLastIndexFrame())+"] -----> SCORE["+player1.getTotalScore()+"]");
			}
			
			
			if(player1.getLastIndexFrame()<9){
				
				//LANCIO PRIMA ROLL
				System.out.print(" Digit first roll score: ");
				scanner = new Scanner(System.in);
				currentFrame.setRoll1(scanner.nextInt());
	
				//CHECK STRIKE
				if(isStrike(currentFrame.getRoll1())){
					currentFrame.setFrameType(FrameType.STRIKE);					
				}else{		
					
					//LANCIO SECONDA ROLL
					System.out.print(" Digit second roll score: ");
					scanner = new Scanner(System.in);			
					currentFrame.setRoll2(scanner.nextInt());
					
					//CHECK SPARE	
					if(isSpare(currentFrame.getRoll1(), currentFrame.getRoll2())){
						//CASO "SPARE"
						currentFrame.setFrameType(FrameType.SPARE);
					}
					
				}
	
				player1.addFrame(currentFrame);
				player1.addScore(currentFrame.getRoll1());			
				player1.addScore(currentFrame.getRoll2());				
				player1.loadTmpStackScores();				
				player1.addCurrentIndexFrame();
			}	
	
		}
		
		
		//LOAD STACK CON ULTIMO FRAME
		if(player1.getLastIndexFrame()==9){
			if (player1.getFrames().get(player1.getLastIndexFrame()).getFrameType().equals(FrameType.STRIKE) || player1.getFrames().get(player1.getLastIndexFrame()).getFrameType().equals(FrameType.SPARE)){
				System.out.print(" Digit extra roll score: ");
				scanner = new Scanner(System.in);
				currentFrame.setRollBonus(scanner.nextInt());
				player1.addFrame(currentFrame);
				player1.addScore(currentFrame.getRollBonus());
			}
			player1.loadTmpStackScores();
		}
		
		if(!player1.getTmpStackScores().isEmpty()){
			calclulateScore(player1);
			System.out.println(" FRAME["+(player1.getLastIndexFrame())+"] -----> TOTAL SCORE["+player1.getTotalScore()+"]");
		}
		
	}



	public static void calclulateScore(Player player1) {
		int scorePoint;
		switch (player1.getFrames().get(player1.getLastIndexFrame()).getFrameType()) {
			case STRIKE:
				if(player1.getTmpStackScores().size() == FrameType.STRIKE.getValue()){
					while(!player1.getTmpStackScores().isEmpty()){
						scorePoint = player1.getTmpStackScores().pop().intValue();
						if(scorePoint>0)
							player1.addTotalScore(scorePoint);
					}	
					player1.addLastIndexFrame();		
				}
				break;
			case SPARE:
				if(player1.getTmpStackScores().size() == FrameType.SPARE.getValue()){
					while(!player1.getTmpStackScores().isEmpty()){
						scorePoint = player1.getTmpStackScores().pop().intValue();
						if(scorePoint>0)
							player1.addTotalScore(scorePoint);
					}
					player1.addLastIndexFrame();		
				}
				break;
			default:
				if(player1.getTmpStackScores().size() == FrameType.NORMAL.getValue()){
					while(!player1.getTmpStackScores().isEmpty()){
						scorePoint = player1.getTmpStackScores().pop().intValue();
						if(scorePoint>0)
							player1.addTotalScore(scorePoint);
					}				
					player1.addLastIndexFrame();		
				}
			break;
		}
	}	
	
	
     
	 private static boolean isStrike(int roll) {
		 return roll == 10;
     }

     private static boolean isSpare(int roll1, int roll2) {
	     return roll1 + roll2 == 10;
     }
     
     
}
