package assignment01;

import java.util.ArrayList;
import java.util.Scanner;

class Engineer{
	String name;
	Engineer(String name){
		this.name = name;
	}
}

class Car {
	int HP;
	public Car(int HP) {
		if(HP<=0) {
			throw new RuntimeException("마력은 0이나 음수가 될 수 없습니다.");
		}
		this.HP = HP;
	}
}

class Benz extends Car{
	String model;
	public Benz(int HP, String model) {
		super(HP);
		this.model = model;
	}
}

class AMG extends Benz{
	Engineer engineer;
	
	public AMG(int HP, String model, Engineer engineer) {
		super(HP, model);
		this.engineer = engineer;
	}
	
	public String getEngineerName() {
		return engineer.name;
	}
}

public class Team01 {

	public static void main(String[] args) {
		
		Engineer engineer1 = new Engineer("김엔진"); 
		Engineer engineer2 = new Engineer("정엔진");	 //엔지니어 두명
		
		ArrayList<Benz> benzList = new ArrayList<>(); //벤츠리스트라는 어레이리스트 만듦
		
		Benz benz = new Benz(200, "A-Class"); //새로운 벤츠 생성
		AMG amg = new AMG(300, "G-Class 63 AMG", engineer1); //amg생성
		//다음을 한 줄로 줄여주세요
		AMG temp = new AMG(522, "AMG_GT", engineer1); 
		Car car = temp;
		
		//ans
		Car car2 = new AMG(522, "AMG_GT", engineer1); 
		
		
		//car의 엔지니어를 [정엔진]씨로 바꾸고, 엔지니어의 이름을 출력해주세요
		
		//ans
		((AMG)car2).engineer = engineer2;
		System.out.println(((AMG)((Benz)car2)).getEngineerName());
		
		benzList.add(benz);
		benzList.add(amg);
		//car를 컴파일에러 없이 benzList에 추가하고, 모델명을 출력해주세요
		
		//ans
		benzList.add((AMG)car2);
		System.out.println(((AMG)car2).model);
		
		
		Scanner sc = new Scanner(System.in);
		
		// 논리적 예외 1
    // 예외가 발생하는 경우를 말해주세요
  	System.out.print("몇 번째 차를 조회할까요? : ");
		int n = sc.nextInt();
		try{
			Benz myBenz = benzList.get(n);
			System.out.println("모델명 : " + myBenz.model);
		}catch (Exception e) {
			System.out.println("해당 차가 존재하지 않습니다.");
		}
	//ans
		/*
		 * 1. int값이 아닌 것이 입력될 경우?(숫자 아닌 다른 값을 입력할 경우)
		 * 2. 배열 크기를 벗어난 더 큰 수가 입력될 경우?
		 */
		
		// 논리적 예외 2
    // 예외가 발생하는 경우를 말해주세요
		try {
			System.out.print("마력을 입력하세요 : ");
			int inputHP = sc.nextInt();	
			Benz yourBenz = new Benz(inputHP, "님이 산 차");
			System.out.println(yourBenz.model + "의 마력은 " + yourBenz.HP + " 입니다.");
		}catch(RuntimeException e) {
			System.out.println("님이 산 차의 " + e.getMessage());
		}
	}
	//ans
	/*
	 * 1. int값을 입력하지 않을 경우?(숫자가 아닌 다른 값을 입력할 경우)
	 * 2. 마력이 0이나 음수일 경우
	 * 
	 */

}


