package lesson07_mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java入門 MVCモデルクラス.<br>
 * C（コントローラ）
 */
@WebServlet("/lesson07_mvc/ControllerServlet")
public class ControllerServlet extends HttpServlet {
	/**
	 * 【MVCの基礎】
	 * MVCはアプリケーションの設計思想の一つ。
	 * Model、View、Controllerの三種の役割でプログラムを分割して、機能を実行すること。
	 *   ・Model：処理...データ操作、その他内部処理を携わる。
	 *   ・View：見た目..シンプルな形では、リスポンスを（クライアントの表示条件に合わせて）返す。APIの一部？
	 *   ・Controller：窓口....シンプルな形では、リクエストを受け、条件別でModelを起動。APIの一部？
	 *
	 * 混乱の原因は、MVCを利用する上で、「View」の役割が混乱を招く。
	 *   ・AsIs：ControllerとModelが「両方」主体となり、Viewの返答データを更新することで、順序性などが複雑になる
	 *   ・ToBe：MVC2では、Controllerが主体となり、ModelとViewを動作する。
	 *        ※Viewから、Modelのデータを参照することで順序性を担保
	 */
	/**
	 * 【クライアント側：JSPの作成】
	 * このチュートリアルでは、リクエスト画面を一つ、リスポンス画面を二つ用意する。
	 * 要点：UserBeanクラスの引用
	 *     ・リスポンス画面の一つに実装する設定：<jsp:useBean id="user" scope="request" class="lesson07_mvc.UserBean" />
	 *     ・Beanクラスを指定、インスタンス名の付与、スコープ設定を行う
	 *     ・Model検索結果をスクリプト式（<%= user.getId() %>）で引用できる
	 *     ※恐らく、①SQLの実行をコントローラ側で、②表示項目の指定をJSP側でやっている感覚かな
	 * 仕様：
	 *     ・基本的に、フォームを利用する：①情報送信の場合は、type=text、②単なる画面遷移の場合、type=buttonとリンク
	 *     ・正常のリクエストの場合、Bean情報を取得して表示（これは普通のHTMLタグ）
	 */
	/**
	 * 【サーバ側：MVCの仕様】
	 *「Controller」
	 *   基本設計
	 *   ・リクエストのKeyを取得する
	 *   ・【インターフェイス設計】Keyを元に、UserBeanの判定・取得処理を呼び出す
	 *   ・判定結果をリスポンスとして返す
	 *
	 *   詳細設計
	 *   ・引数のリクエストを取得し、String変数に格納する
	 *   ・Modelをインスタンス化する
	 *   ・DAO（相当）をインスタンス化する際に、Modelの処理を利用して、データを取得する
	 *   ・取得の成否を確認し、以下の処理を行う
	 *       ①正常の場合：
	 *       	リクエストオブジェクトに、UserBeanオブジェクトを渡す（Keyも設定する）。
	 *       	次に、遷移先画面のリンクを登録する。。
	 *       ②異常の場合：
	 *       	シンプルに遷移先画面のリンクを登録する
	 *   ・前処理を元に、フォワードする
	 *
	 * 「Model」
	 *    詳細設計
	 *    ・DAOをインスタンス化する
	 *    ・Keyの判定を行う
	 *    ・判定結果に基づく値設定を行う
	 *    ・DAOのインスタンスをリターン値に返答する
	 *    補足
	 *    ・判定結果の個所をメソッド化してもいいかな
	 *    ・DAOが、プロパティ定義を行うもの二見える
	 */

	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
    public ControllerServlet() {
        super();
    }

    /**
     * POSTメソッドでリクエストされた場合の処理.
     */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ①ID入力画面で入力されたIDを取得
		String id = request.getParameter("id");

		// ②IDに紐づくユーザ情報をモデルに格納するために指示
		// ②-1 ID処理クラスをインスタンス化
		IdProcessing ip = new IdProcessing();
		// ②-2 ID処理クラスに①で取得したIDを渡してユーザ情報をモデルに格納
		UserBean bean = ip.getUserData(id);

		// ③ビューに画面を表示させるための準備
		RequestDispatcher rd;

		// ③-1 モデルの情報を判定
		if(bean != null) {

			// ③-1-1 モデルの情報が存在する場合
			// ③-1-1-1 setAttributeメソッドを使ってモデルの情報をセット
			request.setAttribute("user", bean);
			// ③-1-1-2 つぎに表示させる画面（ビュー）を指定
			rd = request.getRequestDispatcher("../Lesson07_MVC/userResponse.jsp");

		} else {

			// ③-1-2 モデルの情報が存在しない（IDに紐づくユーザ情報がない）場合
			// ③-1-2-1 つぎに表示させる画面（ビュー）を指定
			rd = request.getRequestDispatcher("../Lesson07_MVC/userError.jsp");
		}

		// ③-2 つぎの画面を表示
		rd.forward(request, response);
	}
}