package aate.gob.pe.serviceImpl;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Optional;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
import javax.naming.ldap.InitialLdapContext;
import javax.naming.ldap.LdapContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import aate.gob.pe.DTO.Login;
import aate.gob.pe.model.Sistema;
import aate.gob.pe.model.Usuario;
import aate.gob.pe.repo.ISistemaRepo;
import aate.gob.pe.repo.IUsuarioRepo;
import aate.gob.pe.service.IUsuarioService;
import aate.gob.pe.util.Encriptador;

@Service
@Configuration
public class UsuarioServiceImp implements UserDetailsService, IUsuarioService {

	@Autowired
	private IUsuarioRepo repo;
	@Autowired
	private ISistemaRepo repoSis;

	@Value("${ldap.security_principal}")
	private String security_principal;

	@Value("${ldap.security_credential}")
	private String security_credential;

	@Value("${ldap.provider_url}")
	private String provider_url;
	
	@Autowired
	private IUsuarioRepo userRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario user = userRepo.buscarUsuarioxLogin(username); //from usuario where nombre := username
		
		if (user == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		
//		user.getRoles().forEach( role -> {
//			authorities.add(new SimpleGrantedAuthority(role.getNombre()));
//		});
		authorities.add(new SimpleGrantedAuthority("ADMIN"));
		
		UserDetails userDetails = new User(user.getUSULOG(), user.getUSUPAS(), authorities);
		
		return userDetails;
	}
	
	@Override
	public Usuario registrar(Usuario t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public Usuario modificar(Usuario t) {
		// TODO Auto-generated method stub
		return repo.save(t);
	}

	@Override
	public List<Usuario> listar() {
		// TODO Auto-generated method stub
		return repo.findAll(Sort.by(Sort.Direction.DESC, "USUCOD"));
	}

	@Override
	public Usuario leer(Integer id) {
		// TODO Auto-generated method stub
		Optional<Usuario> op = repo.findById(id);
		return op.isPresent() ? op.get() : new Usuario();
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repo.deleteById(id);
	}

	@Override
	public List<Usuario> dniFindAll(String dni) {

		List<Usuario> lista = new ArrayList<>();
		repo.dniFindAll(dni).forEach(x -> {
			Usuario cr = new Usuario();
			cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
			cr.setUSUDNI(String.valueOf(x[1]));
			cr.setUSUNOM(String.valueOf(x[2]));
			cr.setUSUAPEPAT(String.valueOf(x[3]));
			cr.setUSUAPEMAT(String.valueOf(x[4]));
			cr.setUSUCOR(String.valueOf(x[5]));
			cr.setUSULOG(String.valueOf(x[6]));
			// cr.setUSUFOT(byte[] (x[7]));
			try {
				cr.setUSUPAS(Encriptador.Encriptar("123"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lista.add(cr);
		});
		return lista;
		// return null;
	}

	@Override
	public List<Usuario> loginFindAll(String login) {

		List<Usuario> lista = new ArrayList<>();
		repo.loginFindAll(login).forEach(x -> {
			Usuario cr = new Usuario();
			cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
			cr.setUSUDNI(String.valueOf(x[1]));
			cr.setUSUNOM(String.valueOf(x[2]));
			cr.setUSUAPEPAT(String.valueOf(x[3]));
			cr.setUSUAPEMAT(String.valueOf(x[4]));
			cr.setUSUCOR(String.valueOf(x[5]));
			cr.setUSULOG(String.valueOf(x[6]));
			lista.add(cr);
		});
		return lista;
	}

	@Override
	public int validaAcceso(Login login) {
		// TODO Auto-generated method stub
		List<Usuario> lista = new ArrayList<>();
		List<Sistema> listaSistema = new ArrayList<>();
		int rpta = 0;
		String Mensaje = "";
		try {
			String passwordEncriptado = Encriptador.Encriptar(login.getPassword());

			if (login.getCorreo() == null) {

				repo.validaAccesoDNIUsuario(login.getDni(), login.getLogin(), passwordEncriptado).forEach(x -> {
					Usuario cr = new Usuario();
					cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
					cr.setUSUDNI(String.valueOf(x[1]));
					cr.setUSUNOM(String.valueOf(x[2]));
					cr.setUSUAPEPAT(String.valueOf(x[3]));
					cr.setUSUAPEMAT(String.valueOf(x[4]));
					cr.setUSUCOR(String.valueOf(x[5]));
					cr.setUSULOG(String.valueOf(x[6]));
					lista.add(cr);
				});

			} else {
				repo.validaAccesoDNICorreo(login.getDni(), login.getCorreo(), passwordEncriptado).forEach(x -> {
					Usuario cr = new Usuario();
					cr.setUSUCOD(Integer.parseInt(String.valueOf(x[0])));
					cr.setUSUDNI(String.valueOf(x[1]));
					cr.setUSUNOM(String.valueOf(x[2]));
					cr.setUSUAPEPAT(String.valueOf(x[3]));
					cr.setUSUAPEMAT(String.valueOf(x[4]));
					cr.setUSUCOR(String.valueOf(x[5]));
					cr.setUSULOG(String.valueOf(x[6]));
					lista.add(cr);
				});
				// rpta = repo.validaAccesoDNICorreo(login.getDni(), login.getCorreo(),
				// passwordEncriptado).isEmpty() ? 0 : 1;
			}

			if (!lista.isEmpty()) {
				if (lista.get(0).getUSUBLO() == '1') {
					Mensaje = "Usuario Bloqueado";
				} else if (lista.get(0).getUSUEST() == '0') {
					Mensaje = "Usuario Inactivo";
				}

				repoSis.siglaFindAll(login.getSigla()).forEach(x -> {
					Sistema cr = new Sistema();
					cr.setSISCOD(Integer.parseInt(String.valueOf(x[0])));
					cr.setSISNOM(String.valueOf(x[1]));
					cr.setSISDES(String.valueOf(x[2]));
					cr.setSISSIG(String.valueOf(x[3]));
					cr.setSISEST(String.valueOf(x[4]).charAt(0));
					cr.setESTREG(String.valueOf(x[5]).charAt(0));
					listaSistema.add(cr);
				});

				/*
				 * if(!listaSistema.isEmpty()) {
				 * 
				 * SistemaUsuario busqueda = new SistemaUsuario();
				 * busqueda.setUSUCOD(lista.get(0).getUSUCOD());
				 * busqueda.setSISCOD(listaSistema.get(0).getSISCOD()); List<SistemaUsuario>
				 * listaSisUsu = sistemaUsuService.buscarSistemaUsuario(busqueda);
				 * if(!listaSisUsu.isEmpty()) { rpta =1; } }
				 */

			} else {
				Mensaje = "Datos Incorrectos";
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			rpta = 0;
		}
		return rpta;
	}

	@Override
	public Usuario BuscarUsuarioLdap(String user) {
		Usuario beUsuario = new Usuario();

		LdapContext ctx = null;
		Hashtable<String, String> env = new Hashtable<String, String>();
		env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
		env.put(Context.SECURITY_AUTHENTICATION, "simple");
		env.put(Context.SECURITY_PRINCIPAL, security_principal);// nombre del usuario
		env.put(Context.SECURITY_CREDENTIALS, security_credential);// contraseña de usuario
		env.put(Context.PROVIDER_URL, provider_url);// URL LDAP :

		try {
			ctx = new InitialLdapContext(env, null);
			System.out.println(ctx);
			SearchControls searchControls = new SearchControls();
			searchControls.setSearchScope(SearchControls.SUBTREE_SCOPE);

			String searchFilter = "(&(objectClass=user)(sAMAccountName=" + user + "))";
			String ldapSearchBase = "DC=aate,DC=gob,DC=pe";
			NamingEnumeration<SearchResult> results = ctx.search(ldapSearchBase, searchFilter, searchControls);
			SearchResult searchResult = null;

			while (results.hasMoreElements()) {
				searchResult = (SearchResult) results.nextElement();
				NamingEnumeration<String> var = searchResult.getAttributes().getIDs();
				String prop;
				int x = 1;
				while (var.hasMoreElements()) {
					prop = var.next();
					/*
					 * System.out.println(x + " " + prop + ": " +
					 * searchResult.getAttributes().get(prop).get()); x++;
					 */

					if (prop.equals("mail")) {
						beUsuario.setUSUCOR(searchResult.getAttributes().get(prop).get().toString());
					}

					if (prop.equals("name")) {
						beUsuario.setUSUNOM(searchResult.getAttributes().get(prop).get().toString());
					}
					if (prop.equals("mailNickname")) {
						beUsuario.setUSULOG(searchResult.getAttributes().get(prop).get().toString());
					}
					// x++;
				}

				/*
				 * Attribute memberOf = searchResult.getAttributes().get("memberOf");
				 * 
				 * for (int i = 0; i < memberOf.size(); i++) { Attributes atts =
				 * ctx.getAttributes(memberOf.get(i) .toString(), new String[] { "CN" });
				 * Attribute att = atts.get("CN"); System.out.println(att.get().toString()); }
				 * 
				 * System.out.println((String)searchResult.getAttributes().get("memberOf").get()
				 * );
				 */
			}
			return beUsuario;
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

		return null;
	}

}
