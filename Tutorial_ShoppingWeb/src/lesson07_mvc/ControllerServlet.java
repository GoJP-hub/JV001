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
@WebServlet("/ControllerServlet")
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
	 *
	 */
	/**
	 * 【サーバ側：Modelの仕様】
	 *
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
			rd = request.getRequestDispatcher("./Lesson06_MVC/userResponse.jsp");

		} else {

			// ③-1-2 モデルの情報が存在しない（IDに紐づくユーザ情報がない）場合
			// ③-1-2-1 つぎに表示させる画面（ビュー）を指定
			rd = request.getRequestDispatcher("./Lesson06_MVC/userError.jsp");
		}

		// ③-2 つぎの画面を表示
		rd.forward(request, response);
	}
}