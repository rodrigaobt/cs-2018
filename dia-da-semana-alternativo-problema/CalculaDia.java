import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author rodrigo
 */
public class CalculaDia {

    public static void main(String[] args) {

        // TODO Auto-generated method stub

        //IMPLLEMENTAR REQUISITOS DE RETIRAR ENTRADA E SAIDA PADRAO
        
        int dataDesejada = 0;
        int anoBissexto = 0;
        int dataReferencia = 0;
        int diaSemana = 0;

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

        
        if (args.length != 4) {
            System.exit(-1);
        } else {
            //MANTER A ORDEM DOS ARGS
            dataDesejada = Integer.parseInt(args[0]);
            anoBissexto = Integer.parseInt(args[1]);
            dataReferencia = Integer.parseInt(args[2]);
            diaSemana = Integer.parseInt(args[3]);
            //System.exit(0);
        }

        //Entrada e saída padrao proibidas
        /*
        Scanner scan = new Scanner(System.in);

        System.out.println("Digite a data cujo dia da semana deseja saber:\n");
        dataDesejada = scan.nextInt(); //FORMATO aaaammdd

        System.out.println("Digite a data referencia:\n");
        dataReferencia= scan.nextInt(); //FORMATO aaaammdd

        System.out.println("Digite o dia da semana da data de referencia:\n");
        diaSemana= scan.nextInt();
        */

        yearObj = dataDesejada/10000;
        if(yearObj <= 999 || yearObj > 9999){ // não pode começar com zero e não pode ter menos que oito dígitos
            System.exit(-1);
        }
        dayObj = dataDesejada%100;
        if(dayObj <= 0 || dayObj > 31){ // dia não pode ser menor que zero ou maior que 31
            System.exit(-1);
        }
        monthObj = (dataDesejada - ((yearObj*10000)+(dayObj))) / 100;
        if(monthObj <=0 || monthObj > 12){ // mês não pode ser menor que zero ou maior que doze
            System.exit(-1);
            //Dia imcompativel com mês
            if(monthObj == 4 || monthObj == 6 || monthObj == 9 || monthObj == 11) {
                if(dayObj > 30){
                    System.exit(-1);
                }
            }else if(monthObj == 2) {
                if(dayObj > 29){
                    System.exit(-1);
                }
            }
        }

        //System.out.println("DATA DESEJADA: "+dayObj+"/"+monthObj+"/"+yearObj);

        yearRef = dataReferencia/10000;
        if(yearRef <= 999 || yearRef > 9999){ // não pode começar com zero e não pode ter menos que oito dígitos
            System.exit(-1);
        }

        dayRef = dataReferencia%100;
        if(dayRef <= 0 || dayRef > 31){ // dia não pode ser menor que zero ou maior que 31
            System.exit(-1);
        }

        monthRef = (dataReferencia - (yearRef*10000)) / 100;
        if(monthRef <=0 || monthRef > 12){ // mês não pode ser menor que zero ou maior que doze
            System.exit(-1);
            //Dia imcompativel com mês
            if(monthRef == 4 || monthRef == 6 || monthRef == 9 || monthRef == 11) {
                if(dayRef > 30){
                    System.exit(-1);
                }
            }else if(monthRef == 2) {
                if(dayRef > 29){
                    System.exit(-1);
                }
            }
        }

        if(diaSemana <= 0 || diaSemana > 6){
            System.exit(-1);
        }
        dayWeek = diaSemana;
        

        //System.out.println("DATA REFERENCIA: "+dayRef+"/"+monthRef+"/"+yearRef);

        day = dayRef;
        month = monthRef;
        year =  yearRef;

        


        if(yearRef > yearObj) { //CASO EM QUE TEM QUE RETROCEDER DA DATA DE REFERENCIA ATÉ A DATA DESEJADA
            do {
                //System.out.println("=>YEAR: "+year);
                if(year == yearObj) {
                    mFim = monthObj;

                }

                for (int i = month; i >= mFim; i--) {
                    //System.out.println("==>Month: "+month);

                    if(year == yearObj && month == mFim) {
                        dFim = dayObj;
                    }

                    for (int j = day; j >= dFim; j--) {
                        //System.out.println("====>Day: "+day);
                        count++;
                        day--;

                        if(dayWeek >= 1) {
                            dayWeek--;
                        }else {
                            dayWeek = 6;
                        }

                    }

                    //System.out.println("===>Count: "+count);
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
            //System.out.println("RESULTADO DIA DA SEMANA: "+(dayWeek+1));//6-dom 5-sab 4-sex 3-qui 2-qua 1-ter 0-seg
            System.exit((dayWeek+1));

        }else if(yearRef < yearObj) { //CASO EM QUE TEM QUE PROGREDIR DA DATA DE REFERENCIA ATÉ A DATA DESEJADA
            do {
                //System.out.println("=>YEAR: "+year);
                mFim = 12;
                if(year == yearObj) {
                    mFim = monthObj;

                }

                for (int i = month; i <= mFim; i++) {
                    //System.out.println("==>Month: "+month);

                    if(year == yearObj && month == mFim) {
                        dFim = dayObj;
                    }else {
                        if(month == 4 || month == 6 || month == 9 || month == 11) {
                            dFim = 30;
                        }else if(month == 2) {
                            if(anoBi(year)) {
                                dFim = 29;
                            }else {
                                dFim = 28;
                            }
                        }else {
                            dFim=31;
                        }
                    }


                    for (int j = day; j <= dFim; j++) {
                        //System.out.println("====>Day: "+day);
                        count++;
                        day++;

                        if(dayWeek <= 6) {
                            dayWeek++;
                        }else {
                            dayWeek = 1;
                        }

                    }

                    //System.out.println("===>Count: "+count);
                    month++;

                    day = 1;

                }
                month=1;
                year++;

            }while(year<=yearObj);
            //System.out.println("RESULTADO DIA DA SEMANA: "+(dayWeek-1));
            System.exit((dayWeek-1));

        }else if(yearRef == yearObj && monthRef == monthObj && dayRef == dayObj) {
            //System.out.println("RESULTADO DIA DA SEMANA: "+dayWeek);
            System.exit(dayWeek);
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