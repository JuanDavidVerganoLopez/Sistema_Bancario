import java.util.ArrayList;
import java.util.List;

public class Banco {

    private final List<Cuenta> cuentas;

    public Banco() {
        cuentas = new ArrayList<>();
    }

    public void agregarCuenta(Cuenta cuenta) {

        if (cuenta == null) {
            throw new IllegalArgumentException(
                    "La cuenta no puede ser null."
            );
        }

        cuentas.add(cuenta);
    }

    public void procesarRetiro(
            Cuenta cuenta,
            double monto)
            throws ExcepcionBancaria {

        if (cuenta == null) {
            throw new IllegalArgumentException(
                    "La cuenta no puede ser null."
            );
        }

        cuenta.retirar(monto);
    }

    public List<Cuenta> getCuentas() {
        return List.copyOf(cuentas);
    }
}
