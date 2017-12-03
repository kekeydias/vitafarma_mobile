package br.com.vitafarma.mobile.dao;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import br.com.vitafarma.mobile.domain.Cliente;
import br.com.vitafarma.mobile.domain.MyEntity;
import br.com.vitafarma.mobile.util.VitafarmaMobileDbException;

public class ClienteDao extends AbstractDao<Cliente> {

	public ClienteDao(Activity activity) {
		super(activity);
	}

	private ContentValues getContentValues(Cliente cliente) {
		ContentValues values = new ContentValues();

		values.put("ID", cliente.getId());
		values.put("NOME", cliente.getNome());
		values.put("CPF", cliente.getCpf());
		values.put("EMAIL", cliente.getEmail());
		values.put("ENDERECO", cliente.getEndereco());

		return values;
	}

	public void save(Cliente cliente) {
		ContentValues values = this.getContentValues(cliente);

		try {
			this.insert(MyEntity.CLIENTES, values);
		} catch (VitafarmaMobileDbException ex) {
			System.out.println(ex);
		}
	}

	public void update(Cliente cliente) {
		ContentValues values = this.getContentValues(cliente);

		try {
			this.update(MyEntity.CLIENTES, cliente.getId(), values);
		} catch (VitafarmaMobileDbException ex) {
			System.out.println(ex);
		}
	}

	public void delete(Cliente cliente) {
		try {
			this.delete(MyEntity.CLIENTES, cliente.getId());
		} catch (VitafarmaMobileDbException ex) {
			System.out.println(ex);
		}
	}

	public List<Cliente> findAll() {
		// All columns
		String[] columns = null;
		String selection = null;
		String[] selectionArgs = null;
		String groupBy = null;
		String having = null;
		String orderBy = null;
		String limit = null;

		Cursor cursor = this.db.query(MyEntity.CLIENTES, columns, selection,
				selectionArgs, groupBy, having, orderBy, limit);

		List<Cliente> result = new ArrayList<Cliente>();
		while (!cursor.isLast()) {
			cursor.moveToNext();

			Integer id = cursor.getInt(cursor.getColumnIndex("ID"));
			String nome = cursor.getString(cursor.getColumnIndex("NOME"));
			String email = cursor.getString(cursor.getColumnIndex("EMAIL"));
			String cpf = cursor.getString(cursor.getColumnIndex("CPF"));
			String endereco = cursor.getString(cursor
					.getColumnIndex("ENDERECO"));

			Cliente cliente = new Cliente();
			cliente.setId(id);
			cliente.setNome(nome);
			cliente.setEndereco(endereco);
			cliente.setEmail(email);
			cliente.setCpf(cpf);

			result.add(cliente);
		}

		return result;
	}

	public Cliente findById(Integer id) {
		List<Cliente> clientes = this.findAll();
		Cliente result = null;

		for (Cliente cliente : clientes) {
			if (cliente.getId().equals(id)) {
				result = cliente;
				break;
			}
		}

		return result;
	}

	public List<Cliente> findByNome(String nome) {
		List<Cliente> clientes = this.findAll();
		List<Cliente> result = new ArrayList<Cliente>();

		for (Cliente cliente : clientes) {
			if (cliente.getNome().contains(nome)) {
				result.add(cliente);
			}
		}

		return result;
	}
}
