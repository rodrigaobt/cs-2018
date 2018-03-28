import java.util.Scanner;
/**
*
* @author rodrigo
*/
public class CalculaDia {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//IMPLLEMENTAR REQUISITOS DE RETIRAR ENTRADA E SAIDA PADRAO
		int dayRef;
		int monthRef;
		int yearRef;
		int count = 0;
		
		int dayObj;
		int monthObj;
		int yearObj;
		
		int day;
		int month;
		int year;
		int dayWeek;
		
		int mFim = 1; //Mes fim
		int dFim = 1; //Dia fim
		
		int dataDesejada;
		int dataReferencia;
		int diaSemana;
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite a data cujo dia da semana deseja saber:\n");
		dataDesejada = scan.nextInt(); //FORMATO aaaammdd
		
		System.out.println("Digite a data referencia:\n");
		dataReferencia= scan.nextInt(); //FORMATO aaaammdd
		
		System.out.println("Digite o dia da semana da data de referencia:\n");
		diaSemana= scan.nextInt();
		
		yearObj = dataDesejada/10000;
		dayObj = dataDesejada%100;
		monthObj = (dataDesejada - ((yearObj*10000)+(dayObj))) / 100;
		
		System.out.println("DATA DESEJADA: "+dayObj+"/"+monthObj+"/"+yearObj);
	
		yearRef = dataReferencia/10000;
		dayRef = dataReferencia%100;
		monthRef = (dataReferencia - (yearRef*10000)) / 100;
		
		System.out.println("DATA REFERENCIA: "+dayRef+"/"+monthRef+"/"+yearRef);
		
		day = dayRef;
		month = monthRef;
		year =  yearRef;
		
		dayWeek = diaSemana;
		
		
		if(yearRef >= yearObj) { //CASO EM QUE TEM QUE RETROCEDER DA DATA DE REFERENCIA ATÉ A DATA DESEJADA
			do {
				System.out.println("=>YEAR: "+year);
				if(year == yearObj) {
					mFim = monthObj;
					
				}
				
					for (int i = month; i >= mFim; i--) {
						System.out.println("==>Month: "+month);
						
						if(year == yearObj && month == mFim) {
							dFim = dayObj;
						}
						
						for (int j = day; j >= dFim; j--) {
							System.out.println("====>Day: "+day);
							count++;
							day--;
							
							if(dayWeek >= 1) {
								dayWeek--;
							}else {
								dayWeek = 6;
							}
							
						}
						
						System.out.println("===>Count: "+count);
						month--;
						
						if(month == 4 || month == 6 || month == 9 || month == 11) {
							day = 30;
						}else if(month == 2) {
							if(anoBi(year)) {
								day = 29;
							}else {
								day = 28;
							}
						}else {
							day=31;
						}
						
					}	
					month=12;
					year--;
	
			}while(year>=yearObj);
			System.out.println("RESULTADO DIA DA SEMANA: "+(dayWeek+1));//6-dom 5-sab 4-sex 3-qui 2-qua 1-ter 0-seg
		}		
	}
	
	public static boolean anoBi( int a) {  
		// se o ano for maior que 400
        if(a % 400 == 0){
            //System.out.println(ano + " é bissexto.");
			return true;
        // se o ano for menor que 400
        } else if((a % 4 == 0) && (a % 100 != 0)){
            //System.out.println(ano + " é bissexto.");
			return true;
        } else{
            //System.out.println(ano + " não é bissexto");
			return false;
        }
	}
}
