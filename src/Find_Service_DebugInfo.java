//A list is given. Each entry in list contains info Time, Service, logInfo

/*Eg:
T1  Service1  Debug
T2 Service2   Error
T2 Service1   Info
T2 Service1   Error
T2 Service1   Error
T2 Service3   Info
T3 Service1   Info

O/P : For time between T1 and T2 return each service's debug info Eg: Service1 has 1Debug, 2Error, 1Info

NOTES: Get an idea how to take the input. Eg: Create a custom object and have variables for time, service, time
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Find_Service_DebugInfo {

    public Map<String, HashMap<String,Integer>> findServiceInfo(List<logObject> l, long time1, long time2){

        Map<String, HashMap<String,Integer>> serviceLogInfoMap = new HashMap<>();

        for(int i =0; i< l.size(); i++){
            if(l.get(i).time < time2 && l.get(i).time < time1){
                if(serviceLogInfoMap.containsKey(l.get(i).serviceName)){
                    HashMap<String,Integer> logInfoMap = serviceLogInfoMap.get(l.get(i).serviceName);
                    if(logInfoMap.containsKey(l.get(i).log)){
                        int val = logInfoMap.get(l.get(i).log);
                        logInfoMap.put(l.get(i).log , val+1);
                    }
                    else{
                        logInfoMap.put(l.get(i).log ,1);
                    }
                }
                else{
                    HashMap<String,Integer> logInfoMap = new HashMap<>();
                    logInfoMap.put(l.get(i).log,1);
                    serviceLogInfoMap.put(l.get(i).serviceName,logInfoMap);
                }

            }
            if(l.get(i).time > time2)
            {
                break;
            }
        }

        printServiceLogInfo( serviceLogInfoMap);
        return serviceLogInfoMap;
    }

    public void printServiceLogInfo(Map<String, HashMap<String,Integer>> serviceLogInfoMap){

        for(Map.Entry<String, HashMap<String,Integer>>  entry : serviceLogInfoMap.entrySet()){

            System.out.println(" Service : " + entry.getKey());

            for(Map.Entry<String,Integer>  entry2 : entry.getValue().entrySet()){
                System.out.println(" Log : " + entry2 .getKey() +  " count :" + entry2.getValue());
            }
        }
    }
}


class logObject{
    Long time;
    String serviceName;
    String log;

}