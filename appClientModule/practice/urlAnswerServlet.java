package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns={"/urlAnswerServlet"})
public class urlAnswerServlet extends HttpServlet {

 static int answerButtonCountUpValue;
 static String[] response_answer = {"A", "B", "C", "D", "E"};

 private static final long serialVersionUID = 1L;

public urlAnswerServlet() {
 super();
	                       }

public void init(ServletConfig config) throws ServletException{
 super.init(config);
 answerButtonCountUpValue = 0;
	                                                            }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 try {
 //パラメータ取得
 String input_answer = request.getParameter("answer");
 //doGet()が呼ばれた回数をカウント
 answerButtonCountUpValue++;
 Map<Integer, String> QA = new HashMap<>();
 QA.put(answerButtonCountUpValue, response_answer[(answerButtonCountUpValue - 1)]);
 //ヘッダ設定
 response.setContentType("text/html; charset= UTF-8");
 //pwオブジェクト
 PrintWriter pw = response.getWriter();
 if(input_answer.equals(QA.get(answerButtonCountUpValue))) {
 pw.print("正解です。");
 } else {
 pw.print("不正解です。");
         }
 //クローズ
 pw.close();
 } catch(Exception e) {
 e.printStackTrace();
                       }
                                                                                                                      }
}


//switch文を使うときに参考に
//リクエストがきた回数をcaseに
//answerButtonCountUpValue++;で次のリクエスト時はcaseを進めていけるように

//switch(count) {
//case 1:
	//if(input_answer == "2") {
		//response_answer = "YES 2";
	//} else {
		//response_answer = "答えが違います。";
	//}
//break;
               //}

