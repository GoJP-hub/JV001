package lesson05_Form;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Java入門 Formデータ連携クラス
 */
@WebServlet("/lesson05_Form/RequestServlet")
public class RequestServlet extends HttpServlet {

	/**
	 * 【Formとは】
	 * Form（入力フォーム）は、Webの技術の一つで、HTMLのタグを利用する
	 * 【Formタグ】
	 * <formの開始タグに、複数の属性を付与することが可能
	 * <form method=... 連携方法の指定（PostやPutなど）
	 * <form action=... 連携先のエージェントの指定（./FormServletなど）。外部で処理を任せている箇所を指定
	 * 　　・@WebServlet("/(名称)")......このJavaの宛先・URLを指定している。この場合、「プロジェクト名/（名称）」
	 * 　　・Formタグからは、"action=./（名称）"は、「プロジェクト名/（名称）」を指定している
	 * 　　※この二つ（自身のアドレス定義、連携先アドレス指定）が適切であることが必要
	 */
	/**
	 * 【Inputタグ】
	 *  <inputのタグは、入力を設定するために必要。同様に、属性を付与することが可能
	 * <input name="XXXX".... これは変数名と同義。Javaサイドで参照する際に、この値を設定する
	 * 　　・Javaサイドで呼びだす際に、txt1 = request.getParameter("XXXX")と記載する場合、getParameterの中が該当
	 *
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * コンストラクタ.
	 */
    public RequestServlet() {
        super();
    }

    /**
     * GETメソッドでリクエストされた場合の処理.
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String text1 = "";	// テキスト1格納用変数
		String text2 = "";	// テキスト2格納用変数

		// JSPの画面から値を取得
		text1 = request.getParameter("text1");
		text2 = request.getParameter("text2");

		// 画面に出力する内容の設定
		// 出力する内容がHTMLであることを設定
		response.setContentType("text/html");
		// 出力する画面の文字コードをUTF-8に設定
		response.setCharacterEncoding("UTF-8");

		// 画面に出力するためのWriterクラスインスタンスを取得
		PrintWriter pw = response.getWriter();

		// HTMLを出力
		pw.println("<html>");
		pw.println("<head>");
		pw.println("<title>Java入門</title>");
		pw.println("</head>");
		pw.println("<body>");
		pw.println("<h1>入力結果</h1>");
		pw.println("<p>入力された値は「" + text1
					+ "」と「" + text2 + "」です。</p>");
		pw.println("</body>");
		pw.println("</html>");
	}
}