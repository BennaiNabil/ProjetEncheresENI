package fr.eni.encheres.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.encheres.bo.Enchere;
import fr.eni.encheres.bo.Utilisateur;
import fr.eni.encheres.dal.UtilisateurDAO;

public class UtilisateurDAOJdbcImpl implements UtilisateurDAO {

	private static final String SELECT_BY_ID = "SELECT * FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SELECT_ALL = "SELECT * FROM UTILISATEURS";
	private static final String INSERT = "INSERT INTO UTILISATEURS VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "UPDATE UTILISATEURS SET pseudo = ?, nom = ?, prenom = ?, email = ?, "
			+ "telephone = ?, rue = ?, code_postal = ?, ville = ?, mot_de_passe = ?, credit = ?, administrateur = ? "
			+ "WHERE no_utilisateur = ?";
	private static final String DELETE = "DELETE FROM UTILISATEURS WHERE no_utilisateur=?";
	private static final String SELECT_BY_PSEUDO = "SELECT * FROM UTILISATEURS WHERE pseudo=?";
	private static final String UNIQUE_PSEUDO_EMAIL = "SELECT * FROM UTILISATEURS WHERE (pseudo=? OR email=?)";
	private static final String UPDATE_CREDIT = "UPDATE UTILISATEURS SET credit = ? WHERE no_utilisateur=? ";

	/**
	 * Méthode qui vérifie l'unicité du pseudo et de l'email dans la base de donnée
	 * 
	 * @param pseudo
	 * @param email
	 * @return
	 */
	@Override
	public boolean checkUnicity(String pseudo, String email) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(UNIQUE_PSEUDO_EMAIL);
			preparedStatement.setString(1, pseudo);
			preparedStatement.setString(2, email);
			resultSet = preparedStatement.executeQuery();
			if (!resultSet.next()) {
				return true;
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
		return false;
	}

	/**
	 * Méthode qui permet d'insérer un utilisateur en base de données dans la table
	 * Utilisateurs
	 *
	 * @param utilisateur l'utilisateur à insérer
	 */
	@Override
	public void insert(Utilisateur utilisateur) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			remplirPreparedStatement(utilisateur, preparedStatement);
			preparedStatement.executeUpdate();
			resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				utilisateur.setNoUtilisateur(resultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
	}

	/**
	 * Méthode qui permet de sélectionner un utilisateur dans la base de données à
	 * partir de son numéro d'utilisateur
	 *
	 * @param id le numéro d'utilisateur
	 * @return utilisateur l'utilisateur demandé
	 */
	@Override
	public Utilisateur selectById(int id) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Utilisateur utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(SELECT_BY_ID);
			preparedStatement.setInt(1, id);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				utilisateur = new Utilisateur(resultSet.getInt("no_utilisateur"), resultSet.getString("pseudo"),
						resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"),
						resultSet.getString("telephone"), resultSet.getString("rue"),
						resultSet.getString("code_postal"), resultSet.getString("ville"),
						resultSet.getString("mot_de_passe"), resultSet.getInt("credit"),
						resultSet.getBoolean("administrateur"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
		return utilisateur;
	}

	/**
	 * Méthode qui permet de sélectionner un utilisateur dans la base de données à
	 * partir de son pseudo
	 *
	 * @param pseudo le pseudo recherché
	 * @return utilisateur l'utilisateur recherché
	 */
	@Override
	public Utilisateur selectByPseudo(String pseudo) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		Utilisateur utilisateur = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(SELECT_BY_PSEUDO);
			preparedStatement.setString(1, pseudo);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				utilisateur = new Utilisateur(resultSet.getInt("no_utilisateur"), resultSet.getString("pseudo"),
						resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"),
						resultSet.getString("telephone"), resultSet.getString("rue"),
						resultSet.getString("code_postal"), resultSet.getString("ville"),
						resultSet.getString("mot_de_passe"), resultSet.getInt("credit"),
						resultSet.getBoolean("administrateur"));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
		return utilisateur;
	}

	/**
	 * Méthode qui permet de récupérer tous les utilisateurs en base de données, et
	 * de les renvoyer sous la forme d'une liste d'instances d'Utilisateur
	 *
	 * @return listeUtilisateurs la liste des utilisateurs
	 */
	@Override
	public List<Utilisateur> selectAll() {
		Statement statement = null;
		ResultSet resultSet = null;
		List<Utilisateur> listeUtilisateurs = new ArrayList<>();
		try (Connection connection = ConnectionProvider.getConnection()) {
			statement = connection.createStatement();
			resultSet = statement.executeQuery(SELECT_ALL);

			while (resultSet.next()) {
				listeUtilisateurs.add(new Utilisateur(resultSet.getInt("no_utilisateur"), resultSet.getString("pseudo"),
						resultSet.getString("nom"), resultSet.getString("prenom"), resultSet.getString("email"),
						resultSet.getString("telephone"), resultSet.getString("rue"),
						resultSet.getString("code_postal"), resultSet.getString("ville"),
						resultSet.getString("mot_de_passe"), resultSet.getInt("credit"),
						resultSet.getBoolean("administrateur")));
			}
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(statement, resultSet);
		}
		return listeUtilisateurs;
	}

	/**
	 * Méthode qui permet de modifier un utilisateur présent en base de données
	 *
	 * @param utilisateur l'utilisateur à modifier
	 */
	@Override
	public void update(Utilisateur utilisateur) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(UPDATE);
			remplirPreparedStatement(utilisateur, preparedStatement);
			preparedStatement.setInt(12, utilisateur.getNoUtilisateur());

			preparedStatement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
	}

	/**
	 * Méthode qui permet de supprimer l'enregistrement de la table Utilisateur qui
	 * correspond à l'objet utilisateur
	 *
	 * @param utilisateur l'utilisateur à supprimer
	 */
	@Override
	public void delete(Utilisateur utilisateur) {
		PreparedStatement preparedStatement = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(DELETE);
			preparedStatement.setInt(1, utilisateur.getNoUtilisateur());
			preparedStatement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, null);
		}
	}

	/**
	 * Méthode qui permet de vérifier si un couple pseudo/mot de passe est valide
	 * (=présent en base de données)
	 *
	 * @param pseudoUtilisateur le pseudo de l'utilisateur
	 * @param motDePasse        le mot de passe de l'utilisateur
	 * @return un boolean qui dit si oui ou non le couple d'identification est
	 *         valide
	 */
	@Override
	public Utilisateur sontBonsIdentifiantsDeConnexion(String pseudoUtilisateur, String motDePasse) {
		Utilisateur utilisateur = selectByPseudo(pseudoUtilisateur);

		if (utilisateur != null) {
			String motDePasseAssocie = utilisateur.getMotDePasse();
			if (motDePasseAssocie.equals(motDePasse)) {
				return utilisateur;
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * Méthode qui permet de fermer les objets ResultSet et Statement à chaque
	 * utilisation (REFACTORED)
	 *
	 * @param preparedStatement le Statement à fermer
	 * @param resultSet         le ResultSet à fermer
	 */
	private void closeResources(Statement preparedStatement, ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException throwables) {
				throwables.printStackTrace();
			}
		}
	}

	/**
	 * Méthode qui permet de remplir les PreparedStatement (REFACTORED)
	 *
	 * @param utilisateur       l'utilisateur concerné par le PreparedStatement
	 * @param preparedStatement le PreparedStatement à remplir
	 * @throws SQLException l'exception levée par les méthodes setXXX de
	 *                      PreparedStatement
	 */
	private void remplirPreparedStatement(Utilisateur utilisateur, PreparedStatement preparedStatement)
			throws SQLException {
		preparedStatement.setString(1, utilisateur.getPseudo());
		preparedStatement.setString(2, utilisateur.getNom());
		preparedStatement.setString(3, utilisateur.getPrenom());
		preparedStatement.setString(4, utilisateur.getEmail());
		preparedStatement.setString(5, utilisateur.getTelephone());
		preparedStatement.setString(6, utilisateur.getRue());
		preparedStatement.setString(7, utilisateur.getCodePostal());
		preparedStatement.setString(8, utilisateur.getVille());
		preparedStatement.setString(9, utilisateur.getMotDePasse());
		preparedStatement.setInt(10, utilisateur.getCredit());
		preparedStatement.setBoolean(11, utilisateur.isEstAdministrateur());
	}

	@Override
	public void updateCreditDown(Utilisateur encherisseurNew, Enchere enchere) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(UPDATE_CREDIT);
			int creditOld = encherisseurNew.getCredit();
			System.out.println("Ancien crédit : " + creditOld);
			int montantEnchere = enchere.getMontantEnchere();
			int nouveauCredit = creditOld - montantEnchere;
			System.out.println("Nouveau crédit : " + nouveauCredit);
			System.out.println("Enchérisseur : " + encherisseurNew.getNoUtilisateur());
			preparedStatement.setInt(1, nouveauCredit);
			preparedStatement.setInt(2, encherisseurNew.getNoUtilisateur());
			preparedStatement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
	}

	@Override
	public void updateCreditUp(Utilisateur encherisseurOld, Enchere enchere) {
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		try (Connection connection = ConnectionProvider.getConnection()) {
			preparedStatement = connection.prepareStatement(UPDATE_CREDIT);
			int creditOld = encherisseurOld.getCredit();
			int montantEnchere = enchere.getMontantEnchere();
			preparedStatement.setInt(1, (creditOld+montantEnchere));
			preparedStatement.setInt(2, encherisseurOld.getNoUtilisateur());
			preparedStatement.executeUpdate();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
		} finally {
			closeResources(preparedStatement, resultSet);
		}
	}
		
}
