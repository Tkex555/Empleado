/**~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad de los Andes (Bogotï¿½ - Colombia)
 * Departamento de Ingenierï¿½a de Sistemas y Computaciï¿½n 
 * Licenciado bajo el esquema Academic Free License version 2.1 
 *
 * Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: n1_empleado
 * Autor: Equipo Cupi2 2017
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ 
 */
package uniandes.cupi2.empleado.mundo;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DecimalFormat;

/**
 * Clase que representa un empleado.
 */
public class Empleado
{
    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Nombre del empleado.
     */
    private String nombre;

    /**
     * Apellido del empleado.
     */
    private String apellido;

    /**
     * Genero del empleado. <br>
     * 1 indica gï¿½nero masculino. <br>
     * 2 indica gï¿½nero femenino. <br>
     */
    private int genero;

    /**
     * Fecha de nacimiento del empleado.
     */
    private Fecha fechaNacimiento;

    /**
     * Fecha de ingreso del empleado a la compaï¿½ï¿½a.
     */
    private Fecha fechaIngreso;

    /**
     * Ruta de la imagen.
     */
    private String imagen;

    /**
     * Salario del empleado.
     */
    private double salario;

    // -----------------------------------------------------------------
    // Mï¿½todos
    // -----------------------------------------------------------------

    /**
     * Construye el empleado. <br>
     * <b>post: </b> Se creï¿½ el empleado con los siguientes valores: <br>
     * Nombre: Pedro, Apellido: Matallana, Gï¿½nero: masculino (1), Fecha de nacimiento: 16-6-1982, Fecha de ingreso: 5-4-2000, Imagen: empleado1.png, Salario: 1500000.
     */
    public Empleado( )
    {
        nombre = "Pedro";
        apellido = "Matallana";
        genero = 1;
        fechaNacimiento = new Fecha( 16, 6, 1982 );
        fechaIngreso = new Fecha( 5, 4, 2000 );
        imagen = "empleado1.png";
        salario = 1500000;
    }

    /**
     * Retorna el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String darNombre( )
    {
        return nombre;
    }

    /**
     * Retorna el genero del empleado.
     * @return Genero del empleado.
     */
    public int darGenero( )
    {
        return genero;
    }

    /**
     * Retorna la fecha de nacimiento del empleado en una cadena.
     * @return Fecha de nacimiento del empleado.
     */
    public String darFechaNacimiento( )
    {
        String strFecha = fechaNacimiento.toString( );
        return strFecha;
    }

    /**
     * Retorna la fecha de ingreso del empleado en una cadena.
     * @return Fecha de ingreso del empleado.
     */
    public String darFechaIngreso( )
    {
        String strFecha = fechaIngreso.toString( );
        return strFecha;
    }

    /**
     * Retorna la ruta de la imagen del empleado.
     * @return Ruta de la imagen.
     */
    public String darImagen( )
    {
        return imagen;
    }

    /**
     * Retorna el salario del empleado.
     * @return Salario del empleado.
     */
    public double darSalario( )
    {
        return salario;
    }

    /**
     * Retorna el apellido del empleado.
     * @return Apellido del empleado.
     */
    public String darApellido( )
    {
        return apellido;
    }

    /**
     * Retorna la edad del empleado en aï¿½os.
     * @return Edad del empleado en aï¿½os.
     */
    public int calcularEdad( )
    {
        Fecha hoy = darFechaActual( );

        int edad = fechaNacimiento.darDiferenciaEnMeses( hoy ) / 12;

        return edad;
    }

    /**
     * Retorna la antigï¿½edad del empleado en aï¿½os.
     * @return Antigï¿½edad del empleado en aï¿½os.
     */
    public int calcularAntiguedad( )
    {
        Fecha hoy = darFechaActual( );
        int antiguedad = fechaIngreso.darDiferenciaEnMeses( hoy ) / 12;

        return antiguedad;
    }

    /**
     * Retorna las prestaciones del empleado usando la fï¿½rmula: p = (a * s)/12 (p: prestaciones, a: antigï¿½edad, s: salario). <br>
     * La antigï¿½edad que se utiliza estï¿½ dada en aï¿½os, asï¿½ que si un empleado lleva menos de un aï¿½o en la empresa, sus prestaciones serï¿½n 0.
     * @return Prestaciones del empleado.
     */
    public double calcularPrestaciones( )
    {
        int antiguedad = calcularAntiguedad( );
        double prestaciones = ( ( double ) ( antiguedad * salario ) ) / 12;
        return prestaciones;
    }

    /**
     * Cambia la informaciï¿½n del empleado con los valores dados por parï¿½metro. <br>
     * <b> post: </b> El nombre, apellido, gï¿½nero, fecha de nacimiento, fecha de ingreso, salario e imagen fueron cambiados con los valores dados por parï¿½metro.
     * @param pNombre Nombre del empleado. pNombre != null && pNombre != "".
     * @param pApellido Apellido del empleado. pApellido != null && pApellido != "".
     * @param pGenero Gï¿½nero del empleado. pGenero == 1 || pGenero == 0.
     * @param pFechaNacimiento Fecha de nacimiento del empleado. pFechaNacimiento != null.
     * @param pFechaIngreso Fecha de ingreso del empleado. pFechaIngreso != null.
     * @param pSalario Salario del empleado. pSalario > 0.
     * @param pImagen Imagen del empleado. pImagen != null && pImagen != "".
     */
    public void cambiarEmpleado( String pNombre, String pApellido, int pGenero, Fecha pFechaNacimiento, Fecha pFechaIngreso, int pSalario, String pImagen )
    {
        nombre = pNombre;
        apellido = pApellido;
        genero = pGenero;
        fechaNacimiento = pFechaNacimiento;
        fechaIngreso = pFechaIngreso;
        salario = pSalario;
        imagen = pImagen;
    }

    /**
     * Cambia el salario del empleado con el valor dado por parï¿½metro. <br>
     * <b>post: </b> El salario tiene el valor ingresado por parï¿½metro.
     * @param pSalario Nuevo salario del empleado. pSalario > 0.
     */
    public void cambiarSalario( double pSalario )
    {
        salario = pSalario;
    }

    /**
     * Retorna la fecha actual.
     * @return Fecha actual.
     */
    public Fecha darFechaActual( )
    {
        GregorianCalendar gc = new GregorianCalendar( );

        int dia = gc.get( Calendar.DAY_OF_MONTH );
        int mes = gc.get( Calendar.MONTH ) + 1;
        int anho = gc.get( Calendar.YEAR );
        Fecha hoy = new Fecha( dia, mes, anho );

        return hoy;

    }

    // -----------------------------------------------------------------
    // Puntos de Extensiï¿½n
    // -----------------------------------------------------------------

    /**
     * Mï¿½todo para la extensiï¿½n 1.
     * @return Respuesta indicando si el empleado es mayor o menor de edad.
     */
    public String metodo1()
    {
        int edad = calcularEdad();
        if(edad >= 18)
        {
            return "El empleado " + nombre + " " + apellido + " es mayor de edad (" + edad + " años)";
        }
        else
        {
            return "El empleado " + nombre + " " + apellido + " es menor de edad (" + edad + " años)";
        }
    }

    /**
     * Mï¿½todo para la extensiï¿½n 2.
     * @return Respuesta con el nombre completo, edad y salario del empleado.
     */
    public String metodo2( )
    {
        String nombreCompleto = nombre + " " + apellido;
        int edad = calcularEdad();
        DecimalFormat df = new DecimalFormat("$###,###.##");
        String salarioFormateado = df.format(salario);
        
        return "Nombre Completo: " + nombreCompleto + "\n" +
               "Edad: " + edad + " Anos" + "\n" +
               "Salario: " + salarioFormateado;
    }

}