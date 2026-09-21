class Solution {

    public String encode(List<String> strs) {
        char SEPRATOR = '#';
        char ESCAPE = '/';

        StringBuilder encoded = new StringBuilder();
        for(String str : strs){
            String new_str = str.replaceAll("/","//").replaceAll("#","/#");
        
            encoded.append(new_str);
            encoded.append("#");
        }

        return encoded.toString();

    }

    public List<String> decode(String str) {
        List<String> decoded = new ArrayList<>();
        String current_str = "";
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '/'){
                i++; 
                current_str += str.charAt(i);
            } else if(str.charAt(i) == '#'){
                decoded.add(current_str);
                current_str = "";
            } else{
                current_str += str.charAt(i);
            }
        }

        return decoded;

    }
}
