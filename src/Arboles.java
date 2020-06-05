/**
 * @author juangalvis
 * @author SantiagoRestrepo
 */
import java.sql.SQLOutput;
import java.util.Scanner;

public class Arboles {

    public static void Menu1()
    {
        System.out.println("ÁRBOLES");
        System.out.println("-----------------");
        System.out.println("[1] BINARIO");
        System.out.println("[2] AVL");
        System.out.println("[3] SALIR");
        System.out.println("-----------------");
        System.out.println("Opción: ");
    }

    public static void Menu2()
    {
        System.out.println("ÁRBOLES BINARIOS");
        System.out.println("-----------------");
        System.out.println("[1] MOSTRAR INORDEN");
        System.out.println("[2] MOSTRAR PREORDEN");
        System.out.println("[3] MOSTRAR POSTORDEN");
        System.out.println("[4] MOSTRAR HOJAS");
        System.out.println("[5] MOSTRAR PADRE");
        System.out.println("[6] MOSTRAR NIVEL");
        System.out.println("[7] MOSTRAR HERMANO");
        System.out.println("[8] MOSTRAR ANCESTROS");
        System.out.println("[9] MOSTRAR PRIMOS");
        System.out.println("[0] SALIR");
    }

    public static void main(String[] args) {

        MainBinario Arbol = new MainBinario(null);
        Scanner sc = new Scanner(System.in);
        Scanner in1 = new Scanner(System.in);
        Scanner in2 = new Scanner(System.in);
        Scanner in3 = new Scanner(System.in);
        int opc1 = 0;
        int opc2 = 0;
        int opc3 = 0;
        int nivel;
        char [] registro;


        System.out.println("DIGITE LA CADENA: ");
        String Cadena = sc.nextLine();
        char[] Caracter = Cadena.toCharArray();
        // PADRE
        Nodo R = new Nodo(Caracter[0]);

        do
        {
            Menu1();
            opc1 = in1.nextInt();
            switch(opc1)
            {
                case 1:

                    Arbol.ConstruirArbol(Caracter, R);

                    do
                    {
                        Menu2();
                        opc2 = in2.nextInt();
                        switch(opc2)
                        {
                            case 1:

                                Arbol.MostrarInorden(Arbol.getPunta());

                                break;

                            case 2:

                                Arbol.MostrarPreorden(Arbol.getPunta());

                                break;

                            case 3:

                                Arbol.MostrarPostorden(Arbol.getPunta());

                                break;

                            case 4:
                                Arbol.mostrarHojas(Arbol.getPunta());
                                break;

                            case 5:
                                Arbol.mostrarPadre(Arbol.getPunta());
                                break;

                            case 6:

                                System.out.println("Digite el registro que quiere buscar: ");
                                registro= sc.nextLine().toCharArray();


                                nivel=Arbol.mostrarNivel(Arbol.getPunta(),0,registro[0]);

                                if( nivel != -1) {
                                    System.out.println("El nivel del registro " + registro[0] + " es: " + nivel);
                                }else {
                                    System.out.println("Registro no encontrado");
                                }


                                break;

                            case 7:

                                System.out.println("Digite el registro que quiere buscar: ");
                                registro= sc.nextLine().toCharArray();

                                Arbol.mostrarHermano(Arbol.getPunta(), registro[0]);

                                break;
                            case 8:
                                System.out.println("Digite el registro que quiere buscar: ");
                                registro= sc.nextLine().toCharArray();

                                Arbol.mostrarPadreAncestro(Arbol.getPunta(), registro[0]);
                                break;

                            case 9:
                                System.out.println("Digite el registro del cual quiere saber los primos: ");
                                registro= sc.nextLine().toCharArray();

                                Arbol.mostrarPrimos(Arbol.getPunta(), registro[0]);
                                break;

                            default:

                                System.out.println("OPCIÓN INVALIDA");

                                break;
                        }

                    }while(opc2 != 0);

                    break;

                case 2:

                    Arbol.construirArbolAVL(Caracter, R);

                    do
                    {
                        Menu2();
                        opc2 = in2.nextInt();
                        switch(opc2)
                        {
                            case 1:

                                Arbol.MostrarInorden(Arbol.getPunta());

                                break;

                            case 2:

                                Arbol.MostrarPreorden(Arbol.getPunta());

                                break;

                            case 3:

                                Arbol.MostrarPostorden(Arbol.getPunta());

                                break;

                            case 4:
                                Arbol.mostrarHojas(Arbol.getPunta());
                                break;

                            case 5:
                                Arbol.mostrarPadre(Arbol.getPunta());
                                break;

                            case 6:

                                System.out.println("Digite el registro que quiere buscar: ");
                                registro= sc.nextLine().toCharArray();


                                nivel=Arbol.mostrarNivel(Arbol.getPunta(),0,registro[0]);

                                if( nivel != -1) {
                                    System.out.println("El nivel del registro " + registro[0] + " es: " + nivel);
                                }else {
                                    System.out.println("Registro no encontrado");
                                }


                                break;

                            case 7:

                                System.out.println("Digite el registro que quiere buscar: ");
                                registro= sc.nextLine().toCharArray();

                                Arbol.mostrarHermano(Arbol.getPunta(), registro[0]);

                                break;
                            case 8:
                                System.out.println("Digite el registro que quiere buscar: ");
                                registro= sc.nextLine().toCharArray();

                                Arbol.mostrarPadreAncestro(Arbol.getPunta(), registro[0]);
                                break;

                            case 9:
                                System.out.println("Digite el registro del cual quiere saber los primos: ");
                                registro= sc.nextLine().toCharArray();

                                Arbol.mostrarPrimos(Arbol.getPunta(), registro[0]);
                                break;

                            default:

                                System.out.println("OPCIÓN INVALIDA");

                                break;
                        }

                    }while(opc2 != 0);



                    break;
            }


        }while(opc1 != 3);
    }
}
