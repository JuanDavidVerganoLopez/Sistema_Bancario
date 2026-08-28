public abstract class Cuenta {

    private final String titular;
    private double saldo;
    private boolean activa;

    protected Cuenta(String titular, double saldoInicial) {

        if (titular == null || titular.isBlank()) {
            throw new IllegalArgumentException(
                    "El titular no puede estar vacío."
            );
        }

        if (saldoInicial < 0) {
            throw new IllegalArgumentException(
                    "El saldo inicial no puede ser negativo."
            );
        }

        this.titular = titular;
        this.saldo = saldoInicial;
        this.activa = true;
    }

    public String getTitular() {
        return titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isActiva() {
        return activa;
    }

    public void activar() {
        activa = true;
    }

    public void desactivar() {
        activa = false;
    }

    public void depositar(double monto)
            throws MontoInvalidoException, CuentaInactivaException {

        validarMonto(monto);
        validarCuentaActiva();

        saldo += monto;
    }

    protected void disminuirSaldo(double monto) {
        saldo -= monto;
    }

    protected void validarMonto(double monto)
            throws MontoInvalidoException {

        if (monto <= 0) {
            throw new MontoInvalidoException(
                    "El monto debe ser mayor que cero."
            );
        }
    }

    protected void validarCuentaActiva()
            throws CuentaInactivaException {

        if (!activa) {
            throw new CuentaInactivaException(
                    "La cuenta está inactiva."
            );
        }
    }

    public abstract void retirar(double monto)
            throws ExcepcionBancaria;
}
