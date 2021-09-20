package lesson11_dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Java入門 データベース接続クラス（DAO）.
 */
/**
 * @author gohir
 *【注意点】
 * DBの接続は正常だが、SQLの結果取得が出来ていないため、随時対応する
 *【①DB設定について】
 *   MySQLをインストールする
 *   ConnectorJというJDBCドライバー（Jar）をダウンロードする
 *   libフォルダ（無い場合は作成した後）に、JDBCドライバーを配置する
 *   DBViewerを設定する
 *       ・（インストールが未了な場合）Help→Eclipse マーケットプレイスより「DBViewer」を検索し、インストールする
 *       ・ビューの一覧にDBViewerが追加されたことを確認し、「DBツリー・ビュー」とSQL実行・ビュー」を追加する
 *   DBツリー・ビューを開き、DBViewerPluginを右クリし、DBの登録を進める
 *       ・DB名を設定した後、「ファイル追加」のボタンを押下する
 *       ・ファイルの指定は、JDBCドライバーのJarを設定する
 *       ・「次へ」を押し、接続情報を以下の通りに設定する
 *           JDBCタイプ Type4
 *           接続文字列 jdbc:mysql://localhost:3306/
 *           接続ユーザ root
 *           接続パスワード MySQL構築時に設定したパスワード
 *           接続スキーマ （空白）
 *       ・接続を確認した後、「完了」を押下する
 *   DBが接続しているため、SQL実行・ビューで操作が可能となる
 *
 *【②DAOについて】
 *   DAO＝Database Access Object
 *   ・データベースの処理を行うクラス
 *   ・DAOを多用するため、ライフサイクル処理で
 *       ・接続系処理を、新規作成するUTIL系クラスに保持し
 *       ・実行系処理を、一つのインターフェイス・親クラスを作成し、オーバーライドで作成するパターンがある
 *
 *   DAOのライフサイクル
 *   ・JDBCドライバーを利用し、DBに接続する
 *        Class.forName("com.mysql.cf.jdbc.Driver") //Jarの中に入っているDriverクラスまでのパス
 *        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample", "root", "password"); // ドライバーの接続情報
 *   ・SQLを実行する
 *        ps = con.prepareStatement("select * from user"); //SQL情報を、Statementクラスの保持する
 *        rs = ps.executeQuery(); // リザルトセットクラスにSQL結果を保存する
 *   ・SQL実行結果に対して処理を行う　※今回は、Select結果の出力
 *        // 今回はSELECT結果の出力
 *        while(rs.next()){
 *           system.out.println(rs.getString("name")); //SQL結果の内、name項目のみをコンソールに出力する
 *        }
 *   ・クローズ処理を行う
 *        if(con != null){
 *           con.close();
 *        }
 *        if(ps != null){
 *           ps.close();
 *        }
 *        if(rs != null){
 *           rs.close();
 *        }
 */
public class SampleDao {

	public static void main(String[] args) {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet  rs  = null;

		try {

			// JDBCドライバのロード
			// 「com.mysql.jdbc.Driver」クラス名
			Class.forName("com.mysql.cj.jdbc.Driver");

			// データベースと接続
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample",
											  "root",
											  "admin");

			ps = con.prepareStatement("select * from user");

			rs = ps.executeQuery();
			System.out.println("Executing SQL");

			while(rs.next()) {
				System.out.println(rs.getString("name"));
			}

		} catch(ClassNotFoundException ce) {

			// JDBCドライバが見つからなかった場合
			ce.printStackTrace();

		} catch (SQLException se) {

			// データベースとの接続に失敗した場合
			se.printStackTrace();

		} finally {

			try {

				System.out.println("Closing DB Connection");
				// データベースとの接続を解除する
				if(con != null) {
					con.close();
				}
				if(ps != null) {
					ps.close();
				}
				if(rs != null) {
					rs.close();
				}

			} catch (SQLException se) {

				// データベースとの接続解除に失敗した場合
				se.printStackTrace();
			}
		}
	}
}