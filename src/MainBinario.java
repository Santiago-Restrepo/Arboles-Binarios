/**
 *
 * @author juangalvis
 */
public class MainBinario {

    private Nodo Punta,p;
    private boolean bandera;

    //MÉTODO CONSTRUIR ÁRBOL
    public void ConstruirArbol(char[] Cadena, Nodo R) {
        Punta = R;
        int Punt = 1;
        Nodo Puntero = R;
        Nodo PunteroAux = null;

        while (Punt != Cadena.length) {

            Puntero = R;
            PunteroAux = null;

            do {

                while (Puntero.getLD() != null && Puntero.getDato() < Cadena[Punt]) {
                    Puntero = Puntero.getLD();
                }

                while (Puntero.getLI() != null && Puntero.getDato() > Cadena[Punt]) {
                    Puntero = Puntero.getLI();
                }

                if (Puntero.getLD() == null && Puntero.getDato() < Cadena[Punt]) {
                    PunteroAux = new Nodo(Cadena[Punt]);

                    Puntero.setLD(PunteroAux);

                }

                if (Puntero.getLI() == null && Puntero.getDato() > Cadena[Punt]) {
                    PunteroAux = new Nodo(Cadena[Punt]);

                    Puntero.setLI(PunteroAux);
                }


            } while (PunteroAux == null);

            Punt++;
        }
    }

    public void construirArbolAVL(char[] Cadena, Nodo R){

        Punta = R;
        int Punt = 1;
        Nodo PunteroAux = null;
        Nodo p=R,q=R,r=R;

        while (Punt != Cadena.length) {//se va a insertar como si fuera un binario normal, pero luego.... to be continue
//DCAGLSKHYJTMPBQ

            r = Punta;
            PunteroAux = null;

            do {

                while (r.getLD() != null && r.getDato() < Cadena[Punt]) {
                    r = r.getLD();
                }

                while (r.getLI() != null && r.getDato() > Cadena[Punt]) {
                    r = r.getLI();
                }

                if (r.getLD() == null && r.getDato() < Cadena[Punt]) {
                    PunteroAux = new Nodo(Cadena[Punt]);
                    PunteroAux.setPadre(r);
                    r.setLD(PunteroAux);



                }

                if (r.getLI() == null && r.getDato() > Cadena[Punt]) {
                    PunteroAux = new Nodo(Cadena[Punt]);
                    PunteroAux.setPadre(r);
                    r.setLI(PunteroAux);

                }


            } while (PunteroAux == null);



            if(Punt>1){//luego es cuando verificará si ya es el 3er nodo que se insertó
                this.p=null;
                bandera=false;
                verificarFactorDeBalance(Punta);//método para ubicar a la "p" (que es un nodo global) en el primer nodo que encuentre desbalanceado (factor de balance 2 o -2)
                p=this.p;
                if(p!=null){//si la p (en este caso no es la global) no es null, significa que encontró un nodo desbalanceado y hay que hacer un cambio (balanceo)
                    if(alturaDeUnRegistro(p.getLI())-alturaDeUnRegistro(p.getLD())==2){//comprobar hacia adonde se hace la rotación con el signo del 2
                        if(alturaDeUnRegistro(p.getLI())>alturaDeUnRegistro(p.getLD())){//parar a q en el hijo mas alto de p
                            q=p.getLI();
                        }else{
                            q=p.getLD();
                        }


                        if(alturaDeUnRegistro(q.getLI())-alturaDeUnRegistro(q.getLD())>0){//rotación simple a la derecha
                            //si entró es porque se va a hacer simple y por tanto ya se tiene la figura en la mente de cómo es y que pasría si q tuviera hijo en el lado donde va la p (liga derecha de q)
                            if(q.getLD()==null){
                                p.setLI(null);
                            }else{
                                p.setLI(q.getLD());
                            }
                            if(p.getPadre()==null)
                            {
                                q.setPadre(null);
                            }else{

                                if(p.getPadre().getLD()==p) {

                                    p.getPadre().setLD(q);
                                }else{
                                    p.getPadre().setLI(q);
                                }
                                q.setPadre(p.getPadre());
                            }

                                p.setPadre(q);
                                q.setLD(p);

                        }else {//rotacción doble a la derecha
                            r=q.getLD();

                            if(r.getLI()==null){//todas las vueltas de rotar y ligar y esas vainas
                                q.setLD(null);
                            }else{
                                q.setLD(r.getLI());
                            }

                            if(r.getLD()==null){//todas las vueltas de rotar y ligar y esas vainas
                                p.setLI(null);
                            }else{
                                p.setLI(r.getLD());
                            }

                            if(p.getPadre()==null){
                                r.setPadre(null);
                            }else{

                                if(p.getPadre().getLD()==p) {

                                    p.getPadre().setLD(r);
                                }else{
                                    p.getPadre().setLI(r);
                                }
                                    r.setPadre(p.getPadre());
                            }
                            r.setLI(q);
                            r.setLD(p);
                            p.setPadre(r);
                            q.setPadre(r);

                        }


                    }else{

                        if(alturaDeUnRegistro(p.getLI())>alturaDeUnRegistro(p.getLD())){//parar a q en el hijo mas alto de p
                            q=p.getLI();
                        }else{
                            q=p.getLD();
                        }

                        if(alturaDeUnRegistro(q.getLI())-alturaDeUnRegistro(q.getLD())<0){//rotación simple a la izquierda
                            //si entró es porque se va a hacer simple y por tanto ya se tiene la figura en la mente de cómo es y que pasría si q tuviera hijo en el lado donde va la p (liga derecha de q)
                            if(q.getLI()==null){
                                p.setLD(null);
                            }else{
                                p.setLD(q.getLI());
                            }
                            if(p.getPadre()==null)
                            {
                                q.setPadre(null);
                            }else{
                                if(p.getPadre().getLD()==p) {
                                    p.getPadre().setLD(q);
                                }else{
                                    p.getPadre().setLI(q);
                                }
                                q.setPadre(p.getPadre());
                            }

                            p.setPadre(q);
                            q.setLI(p);
                            //BMFUHLIASPD

                        }else {//rotacción doble a la izquierda
                            r=q.getLI();

                            if(r.getLD()==null){//todas las vueltas de rotar y ligar y esas vainas
                                q.setLI(null);
                            }else{
                                q.setLI(r.getLD());
                            }

                            if(r.getLI()==null){//todas las vueltas de rotar y ligar y esas vainas
                                p.setLD(null);
                            }else{
                                p.setLD(r.getLI());
                            }

                            if(p.getPadre()==null){
                                r.setPadre(null);
                            }else{

                                if(p.getPadre().getLD()==p) {

                                    p.getPadre().setLD(r);
                                }else{
                                    p.getPadre().setLI(r);
                                }
                                r.setPadre(p.getPadre());
                            }
                            r.setLI(p);
                            r.setLD(q);
                            p.setPadre(r);
                            q.setPadre(r);

                        }
                    }
                }

                while(Punta.getPadre()!=null){
                    Punta=Punta.getPadre();
                }

                System.out.println();
                MostrarInorden(Punta);
                System.out.println();
            }

            Punt++;
        }
    }

    public void verificarFactorDeBalance(Nodo p) {

        if (p != null) {

            int factorDeBalance = alturaDeUnRegistro(p.getLI()) - alturaDeUnRegistro(p.getLD());
            int contador = 0;


            verificarFactorDeBalance(p.getLI());
            verificarFactorDeBalance(p.getLD());

            if ((factorDeBalance == 2 || factorDeBalance == -2) && bandera == false) {
                this.p = p;//
                bandera = true;
            }

        }

    }
    public int alturaDeUnRegistro(Nodo registro){

        if(registro==null){
            return 0;
        }else{
            return 1 + Math.max(alturaDeUnRegistro(registro.getLI()),alturaDeUnRegistro(registro.getLD()));
        }

    }


    public void mostrarHojas(Nodo Padre) {
        if (Padre != null) {
            if (Padre.getLD() == null && Padre.getLI() == null) {
                System.out.println("|" + Padre.getDato() + "|");
            }
            mostrarHojas(Padre.getLI());
            mostrarHojas(Padre.getLD());
        }
    }

    public void mostrarPadre(Nodo Padre) {
        if (Padre != null) {
            if (Padre.getLD() != null || Padre.getLI() != null) {
                System.out.println("|" + Padre.getDato() + "|");
            }
            mostrarPadre(Padre.getLI());
            mostrarPadre(Padre.getLD());
        }
    }

    public int mostrarNivel(Nodo Padre, int contador, char d) {

        while (Padre != null) {
            contador++;
            if (Padre.getDato() == d) {
                return contador;
            }

            if(d < Padre.getDato()){
                Padre= Padre.getLI();
            }else{
                Padre= Padre.getLD();
            }

        }
        return -1;
    }

    public void mostrarHermano(Nodo Padre, char d) {
        boolean bandera= true;
        Nodo q=Padre;
        if(d== Padre.getDato()){
            System.out.println("Como es el padre no tiene hermanos");
        }
        else {

            if (d < Padre.getDato()) {
                q = q.getLI();
            } else {
                q = q.getLD();
            }

            if(encontrarRegistro(Padre,d)) {
                while (bandera) {

                    while (q.getLD() != null && q.getDato() < d) {
                        Padre = q;
                        q = q.getLD();
                    }

                    while (q.getLI() != null && q.getDato() > d) {
                        Padre = q;
                        q = q.getLI();
                    }

                    if (q.getDato() == d) {

                        if (Padre.getLD() == q && Padre.getLI() != null) {
                            System.out.println("El hermano del registro " + d + " es: " + Padre.getLI().getDato());
                        } else if (Padre.getLI() == q && Padre.getLD() != null) {
                            System.out.println("El hermano del registro " + d + " es: " + Padre.getLD().getDato());
                        } else {
                            System.out.println("El registro " + d + " no tiene hermano");
                        }
                        bandera = false;
                    }
                }
            }else {
                System.out.println("Registro no encontrado");
            }
        }
    }

    public void mostrarPadreAncestro(Nodo Padre, char d) {
        boolean bandera= true;
        Nodo q=Padre;
        String familia= "";



        if(Padre.getDato()==d){
            System.out.println(d + " No tiene ancestros");
        }
        else {

            if (d < Padre.getDato()) {
                q = q.getLI();
            } else {
                q = q.getLD();
            }

            if(encontrarRegistro(Padre,d)) {
                while (bandera) {

                    while (q.getLD() != null && q.getDato() < d) {
                        familia+= Padre.getDato();
                        Padre = q;
                        q = q.getLD();
                    }

                    while (q.getLI() != null && q.getDato() > d) {
                        familia+= Padre.getDato();
                        Padre = q;
                        q = q.getLI();
                    }

                    if (q.getDato() == d) {
                        familia+= Padre.getDato();
                        bandera = false;
                    }
                }

                System.out.println("Ancestros de " + d + " : " + familia );
            }else {
                System.out.println("Registro no encontrado");
            }
        }
    }

    public void mostrarPrimos(Nodo Padre, char d){
        boolean bandera= true;
        Nodo q=Padre;
        Nodo abuelo= Padre;
        if(encontrarRegistro(Padre, d)){
            if (d==Padre.getDato()){
                System.out.println("No tiene primos");
            }else {
                while (bandera) {

                    while (q.getLD() != null && q.getDato() < d) {
                        abuelo = Padre;
                        Padre = q;
                        q = q.getLD();
                    }

                    while (q.getLI() != null && q.getDato() > d) {
                        abuelo = Padre;
                        Padre = q;
                        q = q.getLI();
                    }

                    if (q.getDato() == d) {
                        bandera = false;
                    }
                }

                if(abuelo!=Padre) {

                    if (abuelo.getLD() == Padre && abuelo.getLI() != null) {
                        abuelo = abuelo.getLI();
                        System.out.println("Primos: ");
                        if (abuelo.getLI() != null) {
                            System.out.println(abuelo.getLI().getDato());
                        }
                        if (abuelo.getLD() != null) {
                            System.out.println(abuelo.getLD().getDato());
                        }
                        if (abuelo.getLI() == null && abuelo.getLD() == null) {
                            System.out.println("No tiene");
                        }

                    } else if (abuelo.getLD() != null) {
                        abuelo = abuelo.getLD();
                        System.out.println("Primos: ");
                        if (abuelo.getLI() != null) {
                            System.out.println(abuelo.getLI().getDato());
                        }
                        if (abuelo.getLD() != null) {
                            System.out.println(abuelo.getLD().getDato());
                        }
                        if (abuelo.getLI() == null && abuelo.getLD() == null) {
                            System.out.println("No tiene");
                        }
                    }
                }else{
                    System.out.println("El dato digitado es un hijo de la raiz, por tanto no tiene primos");
                }


            }//fin del else


        }else{
            System.out.println("dato no encontrado");
        }

    }



    public boolean encontrarRegistro(Nodo Padre, char d){

        while (Padre != null) {

            if (Padre.getDato() == d) {
                return true;
            }

            if(d < Padre.getDato()){
                Padre= Padre.getLI();
            }else{
                Padre= Padre.getLD();
            }

        }

        return false;
    }





    //acbhteidfg

    /*
    *
    *  public void ConstruirArbol (char[] Cadena, Nodo R)
    {
        Punta = R;
        int Punt = 1;
        Nodo Puntero = R;
        Nodo PunteroAux = null;

        while( Punt != Cadena.length)
        {
            Puntero = R;

            if(Cadena[Punt] > Puntero.getDato() )
            {
                if(Puntero.getLD() == null)
                {
                    PunteroAux = new Nodo(Cadena[Punt]);
                    Puntero.setLD(PunteroAux);

                }else
                {
                    while(Puntero.getLD() != null && Puntero.getDato() < Cadena[Punt])
                    {
                        Puntero = Puntero.getLD();
                    }

                    if(Puntero.getDato() < Cadena[Punt])
                    {
                        PunteroAux = new Nodo(Cadena[Punt]);
                        Puntero.setLD(PunteroAux);
                    }else
                    {
                        while(Puntero.getLI() != null && Puntero.getDato() > Cadena[Punt])
                        {
                            Puntero = Puntero.getLI();
                        }

                        if(Puntero.getDato() > Cadena[Punt])
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLI(PunteroAux);
                        }else
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLD(PunteroAux);
                        }


                        PunteroAux = new Nodo(Cadena[Punt]);
                        Puntero.setLI(PunteroAux);
                    }


                }
            }else
            {
                if(Puntero.getLI() == null)
                {
                    PunteroAux = new Nodo(Cadena[Punt]);
                    Puntero.setLI(PunteroAux);
                }else
                {
                    while(Puntero.getLI() != null && Puntero.getDato() > Cadena[Punt])
                    {
                        Puntero = Puntero.getLI();
                    }

                    if(Puntero.getDato() > Cadena[Punt])
                    {
                        PunteroAux = new Nodo(Cadena[Punt]);
                        Puntero.setLI(PunteroAux);
                    }else
                    {
                        while(Puntero.getLD() != null && Puntero.getDato() < Cadena[Punt])
                        {
                            Puntero = Puntero.getLD();
                        }

                        if(Puntero.getDato() > Cadena[Punt])
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLI(PunteroAux);
                        }else
                        {
                            PunteroAux = new Nodo(Cadena[Punt]);
                            Puntero.setLD(PunteroAux);
                        }
                    }

                }
            }
            Punt++;
        }
    }*/

    //MÉTODO MOSTRAR INORDEN
    public void MostrarInorden(Nodo Padre)
    {
        if(Padre != null)
        {

            MostrarInorden(Padre.getLI());
            System.out.println("|"+ Padre.getDato()+"|");
            MostrarInorden(Padre.getLD());
        }
    }

    /* ARREGLAR ESTOS DOS MÉTODOS */

    public void MostrarPreorden(Nodo Padre)
    {
        if(Padre != null)
        {
            System.out.println("|"+ Padre.getDato()+"|");
            MostrarPreorden(Padre.getLI());
            MostrarPreorden(Padre.getLD());
        }
    }

    public void MostrarPostorden(Nodo Padre)
    {
        if(Padre != null)
        {
            MostrarPostorden(Padre.getLI());
            MostrarPostorden(Padre.getLD());
            System.out.println("|"+ Padre.getDato()+"|");
        }
    }

    public MainBinario(Nodo Punta) {
        this.Punta = Punta;
    }

    public Nodo getPunta() {
        return Punta;
    }

    public void setPunta(Nodo Punta) {
        this.Punta = Punta;
    }


}
