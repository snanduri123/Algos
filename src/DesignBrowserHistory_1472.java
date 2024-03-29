import java.util.HashMap;

/*You have a browser of one tab where you start on the homepage and you can visit another url, get back in the history number of steps or move forward in the history number of steps.

Implement the BrowserHistory class:

BrowserHistory(string homepage) Initializes the object with the homepage of the browser.
void visit(string url) Visits url from the current page. It clears up all the forward history.
string back(int steps) Move steps back in history. If you can only return x steps in the history and steps > x, you will return only x steps. Return the current url after moving back in history at most steps.
string forward(int steps) Move steps forward in history. If you can only forward x steps in the history and steps > x, you will forward only x steps. Return the current url after forwarding in history at most steps.


Example:

Input:
["BrowserHistory","visit","visit","visit","back","back","forward","visit","forward","back","back"]
[["leetcode.com"],["google.com"],["facebook.com"],["youtube.com"],[1],[1],[1],["linkedin.com"],[2],[2],[7]]
Output:
[null,null,null,null,"facebook.com","google.com","facebook.com",null,"linkedin.com","google.com","leetcode.com"]

Explanation:
BrowserHistory browserHistory = new BrowserHistory("leetcode.com");
browserHistory.visit("google.com");       // You are in "leetcode.com". Visit "google.com"
browserHistory.visit("facebook.com");     // You are in "google.com". Visit "facebook.com"
browserHistory.visit("youtube.com");      // You are in "facebook.com". Visit "youtube.com"
browserHistory.back(1);                   // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
browserHistory.back(1);                   // You are in "facebook.com", move back to "google.com" return "google.com"
browserHistory.forward(1);                // You are in "google.com", move forward to "facebook.com" return "facebook.com"
browserHistory.visit("linkedin.com");     // You are in "facebook.com". Visit "linkedin.com"
browserHistory.forward(2);                // You are in "linkedin.com", you cannot move forward any steps.
browserHistory.back(2);                   // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
browserHistory.back(7);                   // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"


Constraints:

1 <= homepage.length <= 20
1 <= url.length <= 20
1 <= steps <= 100
homepage and url consist of  '.' or lower case English letters.
At most 5000 calls will be made to visit, back, and forward.

 */
class DLL{
    String url;
    DLL prev;
    DLL next;

    public DLL(String url){
        this.url = url;
    }
}
public class DesignBrowserHistory_1472 {
    HashMap<String, DLL> map;
    DLL history;
    DLL curr;
    public DesignBrowserHistory_1472(String url){
        map = new HashMap<>();
        history = new DLL(url);
        curr = history;
    }

    public void visit(String url){
        DLL next = new DLL(url);
        curr.next = next;
        next.prev = curr;
        curr = next;
    }

    public String back(int steps){
        int i = 0;
        while(curr.prev!=null && i < steps){
            curr = curr.prev;
            i++;
        }
        return curr.url;
    }

    public String forward(int steps){
        int i = 1;
        while(curr.next!=null && i <= steps){
            curr = curr.next;
            i++;
        }
        return curr.url;
    }

    public static void main(String[] args){
        DesignBrowserHistory_1472 browserHistory = new DesignBrowserHistory_1472("leetcode.com");
        browserHistory.visit("google.com");
        browserHistory.visit("facebook.com");
        browserHistory.visit("youtube.com");
        System.out.println(browserHistory.back(1)); //facebook.com
        System.out.println(browserHistory.back(1)); //google.com
        System.out.println(browserHistory.forward(1)); //facebook.com
        browserHistory.visit("linkedin.com");
        System.out.println(browserHistory.forward(2)); //linkedin.com
        System.out.println(browserHistory.back(2)); //google.com
        System.out.println(browserHistory.back(7)); //leetcode.com
    }

}
