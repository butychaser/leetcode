package word.ladder;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder{
    public static List<String> ladder = Arrays.asList("hot", "dot", "dog", "lot", "log", "cog");
    public static void main(String[] args)
    {
        System.out.println(BFS("hit", "cog", ladder));
    }

    public static int BFS (String beginWord, String endWord, List<String> wordList)
    {
        int distance = 0;
        boolean found = false;
      Queue<String> q = new LinkedList<>();
      Set<String> visited = new HashSet<>();


      q.add(beginWord);
        visited.add(beginWord);
      q.add(null);
      while(!q.isEmpty())
      {
            found = false;
        String str = q.poll();
        if(str != null){

        for(int i = 0; i<str.length(); ++i)
        {
                    char[] cs = str.toCharArray();
                    for (char c = 'a'; c <= 'z'; ++c)
                    {
            cs[i] = c;

                        String strstr = String.valueOf(cs);

         if(strstr.equals(endWord))
                            return ++distance;

                        if (wordList.contains(strstr) && !visited.contains(strstr))
            {
               q.add(strstr);
               visited.add(strstr);
               found =  true;
               break;

            }

           }
           if(found) break;
         }

            }else{
               ++distance;
               if(!q.isEmpty())
                 q.add(null);
            }
        }
        return -1;


      }

    }

