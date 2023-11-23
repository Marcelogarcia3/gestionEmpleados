package GestorDatos;

import gestionEmpleado.Empleado;

import gestionEmpleado.Empleado;
import gestionEmpleado.EmpleadoAsalariado;
import gestionEmpleado.EmpleadoPorHoras;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestorDatos {
    private String nombreArchivo;

    public GestorDatos(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // Método para escribir datos en un archivo de texto
    public void escribirTxt(List<Empleado> listaEmpleados) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(nombreArchivo))) {
            for (Empleado empleado : listaEmpleados) {
                writer.println("Nombre: " + empleado.getNombre());
                writer.println("Tipo de empleado: " + empleado.getTipo());
                writer.println("Salario calculado: " + empleado.calcularSalario());

                // Si el empleado es de tipo EmpleadoPorHoras, escribe las horas trabajadas
                if (empleado instanceof EmpleadoPorHoras) {
                    writer.println("Horas trabajadas: " + ((EmpleadoPorHoras) empleado).getHorasTrabajadas());
                }

                writer.println(); // Línea en blanco para separar empleados
            }
            System.out.println("Datos escritos correctamente en " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método para leer datos desde un archivo de texto
    public List<Empleado> leerTxt() {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(nombreArchivo))) {
            String line;
            String nombre = null;
            String tipo = null;
            double salario = 0.0;
            int horasTrabajadas = 0;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Nombre: ")) {
                    nombre = line.substring("Nombre: ".length());
                } else if (line.startsWith("Tipo de empleado: ")) {
                    tipo = line.substring("Tipo de empleado: ".length());
                } else if (line.startsWith("Salario calculado: ")) {
                    salario = Double.parseDouble(line.substring("Salario calculado: ".length()));
                } else if (line.startsWith("Horas trabajadas: ")) {
                    horasTrabajadas = Integer.parseInt(line.substring("Horas trabajadas: ".length()));
                } else if (line.isEmpty()) {
                    if (nombre != null && tipo != null) {
                        if ("Empleado Asalariado".equals(tipo)) {
                            empleados.add(new EmpleadoAsalariado(nombre, salario));
                        } else if ("Empleado por Horas".equals(tipo)) {
                            empleados.add(new EmpleadoPorHoras(nombre, salario, horasTrabajadas));
                        }
                    }
                    nombre = null;
                    tipo = null;
                    salario = 0.0;
                    horasTrabajadas = 0;
                }
            }
            System.out.println("Datos leídos correctamente desde " + nombreArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return empleados;
    }
}

