package gestionEmpleado;
import java.io.Serializable;

public class EmpleadoPorHoras extends Empleado implements Serializable {
	private double salarioPorHora;
	private int horasTrabajadas;

	public EmpleadoPorHoras(String nombre, double salarioPorHora, int horasTrabajadas) {
		super(nombre, 0); // El salario base se establece en 0 para este tipo de empleado
		this.salarioPorHora = salarioPorHora;
		this.horasTrabajadas = horasTrabajadas;
	}


	public int getHorasTrabajadas() {
		return horasTrabajadas;
	}


	@Override
	public double calcularSalario() {
		return salarioPorHora * horasTrabajadas;
	}

	@Override
	public String getTipo() {
		return "Empleado por Horas";
	}

	@Override
	public String toString() {
		return "EmpleadoPorHoras{" +
				"nombre='" + getNombre()  +
				", salarioPorHora=" + salarioPorHora +
				", horasTrabajadas=" + horasTrabajadas +
				", salario mensual=" + calcularSalario()+
				'}';
	}
}