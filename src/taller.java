import edu.princeton.cs.stdlib.StdDraw;

import java.awt.*;
public class taller {
    public static void lineas (double x0, double y0, double x1, double y1, double Vx0, double Vy0, double Vx1, double Vy1, Color[] colores) {

        //Este subprograma crea 6 lineas que tienen misma velocidad y una separacion ligera para que parezca que las lineas siguen a una linea inicial

        for (int i = 0; i < 6; i++) {

            //colisiones PARA LAS NUEVAS LINEAS
            if (Math.abs(x0 + Vx0) > 1.0) {
                Vx0 = -Vx0;
                Vx1 = -Vx1;

            }
            if (Math.abs(y0 + Vy0) > 1.0) {
                Vy0 = -Vy0;
                Vy1 = -Vy1;

            }
            if (Math.abs(x1 + Vx1) > 1.0) {
                Vx1 = -Vx1;
                Vx0 = -Vx0;

            }
            if (Math.abs(y1 + Vy1) > 1.0) {
                Vy1 = -Vy1;
                Vy0 = -Vy0;
            }

            //actualizacion de posicion
            x0 += Vx0;
            x1 += Vx1;
            y0 += Vy0;
            y1 += Vy1;

            // dibuja las lineas y genera una pausa para que se cree un delay
            StdDraw.setPenColor(colores[i]);
            StdDraw.line(x0, y0, x1, y1);
            StdDraw.pause(2);
        }
    }
    public static void main(String[] args) {

        // se establecen limites se define la escala y se evita el parpadeo de la pantalla
        double min = -1;
        double max = 1;
        StdDraw.setXscale(min, max);
        StdDraw.setYscale(min, max);
        StdDraw.enableDoubleBuffering();

        //COLORES A UTILIZAR
        Color[] colores = {Color.green, Color.pink, Color.blue, Color.cyan, Color.RED, Color.BLACK};

        // se crean los primeros pares ordenados
        double x0 = min + (max - min) * Math.random() ;
        double y0 = min + (max - min) * Math.random() ;
        double x1 = min + (max - min) * Math.random() ;
        double y1 = min + (max - min) * Math.random() ;

        //velocidad aleatoria reducida para eje x e y
        double Vx0 = Math.random() / 15;
        double Vx1 = Math.random() / 15;
        double Vy0 = Math.random() / 15;
        double Vy1 = Math.random() / 15;

        while (true) {
            //colisiones
            if (Math.abs(x0 + Vx0) > 1.0) {
                Vx0 = -Vx0;
                Vx1 = -Vx1;
            }
            if (Math.abs(y0 + Vy0) > 1.0) {
                Vy0 = -Vy0;
                Vy1 = -Vy1;
            }
            if (Math.abs(x1 + Vx1) > 1.0) {
                Vx1 = -Vx1;
                Vx0 = -Vx0;
            }
            if (Math.abs(y1 + Vy1) > 1.0) {
                Vy1 = -Vy1;
                Vy0 = -Vy0;
            }

            //actualizacion de posicion
            x0 += Vx0;
            x1 += Vx1;
            y0 += Vy0;
            y1 += Vy1;
            //SE CREN LAS LINEAS Y SE LIMPIAN LOS RASTROS
            lineas(x0, y0, x1, y1, Vx0, Vy0, Vx1, Vy1, colores);
            StdDraw.show();
            StdDraw.clear();
        }
    }
}