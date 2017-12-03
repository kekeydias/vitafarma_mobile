package br.com.vitafarma.mobile.dao;

import java.util.Locale;

import android.app.Activity;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import br.com.vitafarma.mobile.domain.MyEntity;
import br.com.vitafarma.mobile.util.VitafarmaMobileDbException;

public abstract class AbstractDao<E extends MyEntity> {

	protected Activity activity;
	protected SQLiteDatabase db;
	protected static final String DATABASE_NAME = "VitafarmaMobile.db";
	protected static final Integer DATABASE_VERSION = 1;

	public AbstractDao(Activity activity) {
		this.activity = activity;
		this.initDatabase();
	}

	protected void initDatabase() {

		this.db = this.activity.openOrCreateDatabase(AbstractDao.DATABASE_NAME,
				SQLiteDatabase.CREATE_IF_NECESSARY, null);

		this.db.setVersion(AbstractDao.DATABASE_VERSION);
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

	public SQLiteDatabase getDb() {
		return this.db;
	}

	protected void executeSql(final String sql) throws VitafarmaMobileDbException {
		if (!this.db.isOpen()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE CLOSED.");
		}

		if (this.db.isReadOnly()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE IS READ ONLY.");
		}

		try {
			// Não retorna dado (comandos de create, alter, etc)
			this.db.execSQL(sql);
		} catch (Exception ex) {
			throw new VitafarmaMobileDbException(ex, "Erro ao executar o SQL:");
		}
	}

	protected void insert(String table, ContentValues values)
			throws VitafarmaMobileDbException {
		if (!this.db.isOpen()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE CLOSED.");
		}

		if (this.db.isReadOnly()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE IS READ ONLY.");
		}

		try {
			this.db.insert(table, null, values);
		} catch (Exception ex) {
			throw new VitafarmaMobileDbException(ex,
					"Erro ao inserir um objeto na tabela " + table + ":");
		}
	}

	protected void update(String table, Integer id, ContentValues values)
			throws VitafarmaMobileDbException {
		if (id == null) {
			return;
		}

		if (!this.db.isOpen()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE CLOSED.");
		}

		if (this.db.isReadOnly()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE IS READ ONLY.");
		}

		try {
			this.db.update(table, values, "ID=" + id, null);
		} catch (Exception ex) {
			throw new VitafarmaMobileDbException(ex,
					"Erro ao atualizar um objeto da tabela " + table + ":");
		}
	}

	protected void delete(String table, Integer id)
			throws VitafarmaMobileDbException {
		if (id == null) {
			return;
		}

		if (!this.db.isOpen()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE CLOSED.");
		}

		if (this.db.isReadOnly()) {
			throw new VitafarmaMobileDbException("ERROR: DATABASE IS READ ONLY.");
		}

		try {
			String whereClause = "ID = ?";
			String[] whereArgs = { id.toString() };

			this.db.delete(table, whereClause, whereArgs);
		} catch (Exception ex) {
			throw new VitafarmaMobileDbException(ex,
					"Erro ao remover um objeto da tabela " + table + ":");
		}
	}
}
