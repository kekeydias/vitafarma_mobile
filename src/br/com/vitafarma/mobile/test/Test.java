package br.com.vitafarma.mobile.test;

import java.util.Locale;

import android.app.Activity;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import br.com.vitafarma.mobile.dao.ClienteDao;
import br.com.vitafarma.mobile.domain.Cliente;
import br.com.vitafarma.mobile.domain.MyEntity;
import br.com.vitafarma.mobile.util.InputOutputUtils;

public class Test extends Activity {
	private SQLiteDatabase db;
	private static final String DATABASE_NAME = "VitafarmaMobileTest.db";
	private static final Integer DATABASE_VERSION = 1;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.runTest();
	}

	private final void runTest() {
		this.initDatabase();

		Cliente cliente = new Cliente();
		ClienteDao daoTest = new ClienteDao(this);

		cliente.setId(null);
		cliente.setNome("Cleiton Mendes");
		cliente.setEndereco("Monte Golgota 97 Vila dos Montes");
		cliente.setEmail("kekeydias@gmail.com");

		try {
			daoTest.save(cliente);
			System.out.println("Sucesso!!!");
			System.out.println(cliente);
		} catch (Exception ex) {
			System.out.println("Erro: " + ex.getMessage());
		}

		Integer totalClientes = daoTest.findAll().size();
		InputOutputUtils.showAlert(this, "Total de clientes cadastrados",
				totalClientes.toString());

		daoTest.closeDatabase();
	}

	protected void initDatabase() {

		this.db = openOrCreateDatabase(Test.DATABASE_NAME,
				SQLiteDatabase.CREATE_IF_NECESSARY, null);

		this.db.setVersion(Test.DATABASE_VERSION);
		this.db.setLocale(Locale.getDefault());
		// this.db.setLockingEnabled(true);

		final String CREATE_TABLE_CLIENTES = "CREATE TABLE "
				+ MyEntity.CLIENTES + " ("
				+ " ID INTEGER PRIMARY KEY AUTOINCREMENT,"
				+ " NOME TEXT, EMAIL TEXT, CPF TEXT, ENDERECO TEXT);";

		try {
			this.db.execSQL(CREATE_TABLE_CLIENTES);
		} catch (Exception ex) {
			System.out.println("A tabela " + MyEntity.CLIENTES + " ja existe.");
		}
	}

	public void closeDatabase() {
		this.db.close();
	}
}
