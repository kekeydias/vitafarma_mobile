package br.com.vitafarma.mobile;

import java.util.Vector;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import br.com.vitafarma.mobile.dao.ClienteDao;
import br.com.vitafarma.mobile.domain.Cliente;
import br.com.vitafarma.mobile.util.InputOutputUtils;

public class VitafarmaMobile extends Activity {
	Vector<Cliente> listClientes;

	private EditText ednome;
	private EditText edcpf;
	private EditText edemail;
	private EditText edendereco;

	private ClienteDao dao;
	private Cliente clienteAux;
	private int position = 0;

	private void carregaTelaPrincipal() {
		this.setContentView(R.layout.main);
		Button btcadpess = (Button) findViewById(R.id.btcadclientes);
		Button btlistapess = (Button) findViewById(R.id.btlistclientes);
		Button btsair = (Button) findViewById(R.id.btsair);

		btcadpess.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				carregaTelaCadastro();
			}
		});

		btlistapess.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				carregaListaPessoas();
			}
		});

		btsair.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				System.exit(0);
			}
		});
	}

	private void carregaTelaCadastro() {
		this.setContentView(R.layout.novo_cliente);
		Button btcadastrar = (Button) findViewById(R.cadastro.btcadastro);
		Button btvoltar = (Button) findViewById(R.cadastro.btvoltar);

		btcadastrar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				try {
					Cliente cliente = new Cliente();

					ednome = (EditText) findViewById(R.campo.nome);
					edcpf = (EditText) findViewById(R.campo.cpf);
					edemail = (EditText) findViewById(R.campo.email);
					edendereco = (EditText) findViewById(R.campo.endereco);

					cliente.setId(null);
					cliente.setNome(ednome.getText().toString());
					cliente.setCpf(edcpf.getText().toString());
					cliente.setEmail(edemail.getText().toString());
					cliente.setEndereco(edendereco.getText().toString());

					try {
						dao.save(cliente);
						System.out.println(cliente);
					} catch (Exception ex) {
						showAlert("Erro: ", ex.getMessage());
					}

					showAlert("Aviso", "Cadastro efetuado com sucesso");
				} catch (Exception ex) {
					showAlert("Erro", "Erro ao cadastrar.");
				}
			}
		});

		btvoltar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				carregaTelaPrincipal();
			}
		});
	}

	private void carregaListaPessoas() {
		this.listClientes = new Vector<Cliente>(this.dao.findAll());

		if (this.listClientes == null || this.listClientes.size() == 0) {
			this.showAlert("Aviso", "Nenhum registro cadastrado");
			this.carregaTelaPrincipal();
			return;
		}

		this.setContentView(R.layout.listar_clientes);

		TextView fIdCliente = (TextView) findViewById(R.field.idcliente);
		TextView fNome = (TextView) findViewById(R.field.nome);
		TextView fCpf = (TextView) findViewById(R.field.cpf);
		TextView fEmail = (TextView) findViewById(R.field.email);
		TextView fEndereco = (TextView) findViewById(R.field.endereco);

		Button btanterior = (Button) findViewById(R.lista.btanterior);
		Button btproximo = (Button) findViewById(R.lista.btproximo);
		Button btvoltar = (Button) findViewById(R.lista.btvoltar);

		this.clienteAux = this.listClientes.get(this.position);

		fIdCliente.setText(this.clienteAux.getId() == null ? ""
				: this.clienteAux.getId().toString());
		fNome.setText(this.clienteAux.getNome());
		fCpf.setText(this.clienteAux.getCpf());
		fEmail.setText(this.clienteAux.getEmail());
		fEndereco.setText(this.clienteAux.getEndereco());

		btvoltar.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				carregaTelaPrincipal();
			}
		});

		btanterior.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				if (position == 0) {
					return;
				}

				position--;
				clienteAux = listClientes.get(position);

				TextView fIdCliente = (TextView) findViewById(R.field.idcliente);
				TextView fNome = (TextView) findViewById(R.field.nome);
				TextView fCpf = (TextView) findViewById(R.field.cpf);
				TextView fEmail = (TextView) findViewById(R.field.email);
				TextView fEndereco = (TextView) findViewById(R.field.endereco);

				fIdCliente.setText(clienteAux.getId() == null ? "" : clienteAux
						.getId().toString());
				fNome.setText(clienteAux.getNome());
				fCpf.setText(clienteAux.getCpf());
				fEmail.setText(clienteAux.getEmail());
				fEndereco.setText(clienteAux.getEndereco());
			}
		});

		btproximo.setOnClickListener(new View.OnClickListener() {
			public void onClick(View arg0) {
				if (position == listClientes.size() - 1) {
					return;
				}

				position++;
				clienteAux = listClientes.get(position);

				TextView fIdCliente = (TextView) findViewById(R.field.idcliente);
				TextView fNome = (TextView) findViewById(R.field.nome);
				TextView fCpf = (TextView) findViewById(R.field.cpf);
				TextView fEmail = (TextView) findViewById(R.field.email);
				TextView fEndereco = (TextView) findViewById(R.field.endereco);

				fIdCliente.setText(clienteAux.getId() == null ? "" : clienteAux
						.getId().toString());
				fNome.setText(clienteAux.getNome());
				fCpf.setText(clienteAux.getCpf());
				fEmail.setText(clienteAux.getEmail());
				fEndereco.setText(clienteAux.getEndereco());
			}
		});
	}

	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		this.listClientes = new Vector<Cliente>();
		this.dao = new ClienteDao(this);

		this.carregaTelaPrincipal();
	}

	private void showAlert(String title, String message) {
		InputOutputUtils.showAlert(this, title, message);
	}
}
