package com.jjbike.utils;

import org.apache.http.Consts;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.fluent.Request;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.URL;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class ZJFunctions {

    // private static SaeKV kv = null;
    // private static SaeMemcache mc = null;
    // 本地的memcached服务
    // private static MemcachedClient localMC = null;
    private static ObjectMapper objectMapper = null;

    /**
     * 判断String是否为空
     *
     */
    public static boolean isEmptyString(String value) {
        if (value == null || value.length() == 0) {
            return true;
        }
        return false;
    }

    /**
     * 返回单列kv
     *
     * @return
     */
    // public static SaeKV getSaeKV() {
    // if (null == kv) {
    // kv = new SaeKV();
    // kv.init();
    // }
    //
    // return kv;
    // }

    /**
     * 返回单列mc
     *
     * @return
     */
    // public static SaeMemcache getMc() {
    // if (null == mc) {
    // mc = new SaeMemcache();
    // mc.init();
    // }
    //
    // return mc;
    // }

    /**
     * 返回本地缓存
     *
     * @return
     * @throws Exception
     */
    // public static MemcachedClient getLocalMC(){
    // if (null == localMC) {
    // try {
    // localMC = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
    // } catch (IOException e) {
    // // TODO Auto-generated catch block
    // e.printStackTrace();
    // }
    // }
    //
    // return localMC;
    // }

    /**
     * 返回单例 ObjectMapper
     *
     * @return
     */
    public static ObjectMapper getObjectMapper() {
        if (null == objectMapper) {
            objectMapper = new ObjectMapper();
        }

        return objectMapper;
    }

    // TimeStamp2Date
    public static String[] TimeStamp2Date(String timestampString) {
        String formats = "yyyy-MM-dd HH:mm:ss";
        Long timestamp = Long.parseLong(timestampString) * 1000;
        String date = new SimpleDateFormat(formats)
                .format(new Date(timestamp));

        String[] resultStrings = date.split(" ");
        return resultStrings;
    }

    /**
     * 获取当天的日期，比如 20150428
     *
     * @return
     */
    public static String zj_GetYmdNumberTime() {
        String formats = "yyyyMMdd";
        String date = new SimpleDateFormat(formats)
                .format(new Date());

        return date;
    }

    /**
     * 取指定的Unix时间戳（秒），对应的年月日数字，如：20130120 表示2013-01-20
     *
     * @param
     */
    public static String zj_GetYmdNumberTimeFrom(long timestamp) {
        String formats = "yyyyMMdd";
        String date = new SimpleDateFormat(formats)
                .format(new Date(timestamp * 1000));

        return date;
    }

    /**
     * 取指定的Unix时间戳（秒），对应的小时分钟数字，如：0120 表示1:20分
     *
     * @param
     */
    public static String zj_GetHiNumberTimeFrom(long timestamp) {
        String formats = "HHmm";
        String date = new SimpleDateFormat(formats)
                .format(new Date(timestamp * 1000));

        return date;
    }

    /**
     * 取指定时间所在周的星期一日期，返回数据格式为: 20130701
     *
     * @param
     */
    public static String zj_GetMondayTimeFrom(long timestamp) {
        long time = timestamp;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(time * 1000));
        int w = calendar.get(Calendar.DAY_OF_WEEK) - 1;// 周日到周六 0-6
        if (w == 0) {
            w = 7;
        }
        time -= (w - 1) * 86400;

        return ZJFunctions.zj_GetYmdNumberTimeFrom(time);
    }

    /**
     * 取指定Unix时间所在月份的1号日期，如: 20130701
     *
     * @param
     */
    public static String zj_GetYm01NumberTimeFrom(long timestamp) {
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        Calendar cal_1 = Calendar.getInstance();// 获取当前日期
        cal_1.setTime(new Date(timestamp * 1000));
        cal_1.add(Calendar.MONTH, 0);
        cal_1.set(Calendar.DAY_OF_MONTH, 1);// 设置为1号,当前日期既为本月第一天
        String firstDay = format.format(cal_1.getTime());

        return firstDay;
    }

    /**
     *
     */
    public static void MyThreadStop(int second) {
        try {
            Thread.sleep(second * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 判断socket是否断开
     *
     * @param s
     * @return
     */
    public static boolean isScoketConnected(Socket s) {
        try {
            s.sendUrgentData(0xFF);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 获取真实IP地址
     *
     * @param request
     * @return
     */
    public static String getRemortIP(HttpServletRequest request) {
        if (request.getHeader("x-forwarded-for") == null) {
            return request.getRemoteAddr();
        }
        return request.getHeader("x-forwarded-for");
    }


    /**
     * Http上传文件
     *
     * @param serverUrl
     * @param stringParam
     * @param fileParam
     * @return
     * @throws Exception
     */
    public static String httpUploadFile(String serverUrl,
                                        Map<String, String> stringParam, Map<String, byte[]> fileParam)
            throws Exception {
        // 每个post参数之间的分隔。随意设定，只要不会和其他的字符串重复即可。
        String BOUNDARY = "----------HV2ymHFg03ehbqgZCaKO6jyH";
        // 向服务器发送post请求
        URL url = new URL(serverUrl/* "http://127.0.0.1:8080/test/upload" */);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // 发送POST请求必须设置如下两行

        connection.setDoOutput(true);
        connection.setDoInput(true);
        connection.setUseCaches(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Connection", "Keep-Alive");
        connection.setRequestProperty("Charset", "UTF-8");
        connection.setRequestProperty("Content-Type",
                "multipart/form-data; boundary=" + BOUNDARY);

        // 头
        String boundary = BOUNDARY;
        // 传输内容
        StringBuffer contentBody = new StringBuffer("--" + BOUNDARY);
        // 尾
        String endBoundary = "\r\n--" + boundary + "--\r\n";
        OutputStream out = connection.getOutputStream();

        // 处理文字形式的POST请求
        for (Map.Entry<String, String> p : stringParam.entrySet()) {
            contentBody.append("\r\n")
                    .append("Content-Disposition: form-data; name=\"")
                    .append(p.getKey() + "\"").append("\r\n").append("\r\n")
                    .append(p.getValue()).append("\r\n").append("--")
                    .append(boundary);

        }

        String boundaryMessage1 = contentBody.toString();
        out.write(boundaryMessage1.getBytes("utf-8"));

        // 处理文件上传
        for (Map.Entry<String, byte[]> f : fileParam.entrySet()) {
            contentBody = new StringBuffer();

            contentBody
                    .append("\r\n")
                    .append("Content-Disposition:form-data; name=\"")
                    .append(f.getKey() + "\"; ")
                    // form中field的名称
                    .append("\r\n")
                    .append("Content-Type:application/octet-stream")
                    .append("\r\n\r\n");

            String boundaryMessage2 = contentBody.toString();
            out.write(boundaryMessage2.getBytes("utf-8"));
            out.write(f.getValue(), 0, f.getValue().length);

            contentBody.append("------------HV2ymHFg03ehbqgZCaKO6jyH");
            String boundaryMessage = contentBody.toString();
            out.write(boundaryMessage.getBytes("utf-8"));

        }
        out.write("------------HV2ymHFg03ehbqgZCaKO6jyH--\r\n"
                .getBytes("UTF-8"));

        // 写结尾
        out.write(endBoundary.getBytes("utf-8"));
        out.flush();
        out.close();

        // 从服务器获得回答的内容
        String strLine = "";
        String strResponse = "";
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        while ((strLine = reader.readLine()) != null) {
            strResponse += strLine;
        }
        return strResponse;

    }

    /**
     * 生成UUID
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replaceAll("-", "");
    }

    /**
     * 得到某年某月的第一天第几点时间
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getFirstDayOfMonth(int year, int month, int hour) {

        Calendar cal = Calendar.getInstance();

        if (year >= 0) {
            cal.set(Calendar.YEAR, year);
        }
        if (month >= 0) {
            cal.set(Calendar.MONTH, month - 1);
        }

        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        if (hour >= 0) {
            cal.set(Calendar.HOUR_OF_DAY, hour);
        }
        cal.set(Calendar.MINUTE, 0);

        cal.set(Calendar.SECOND, 0);

//		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//				.format(cal.getTime()));
        return cal.getTime();
    }

    /**
     * 得到某年某月的最后一天第几点时间
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getLastDayOfMonth(int year, int month, int hour) {

        Calendar cal = Calendar.getInstance();

        if (year >= 0) {
            cal.set(Calendar.YEAR, year);
        }

        if (month >= 0) {
            cal.set(Calendar.MONTH, month - 1);
        }
        cal.set(Calendar.DAY_OF_MONTH,
                cal.getActualMaximum(Calendar.DAY_OF_MONTH));

        if (hour >= 0) {
            cal.set(Calendar.HOUR_OF_DAY, hour);
        }
        cal.set(Calendar.MINUTE, 0);

        cal.set(Calendar.SECOND, 0);

        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                .format(cal.getTime()));

        return cal.getTime();

    }

    /**
     * 获取某年某月某日某时日期
     *
     * @param year
     * @param month
     * @return
     */
    public static Date getDateOfYearAndMonthAndDayAndHour(int year, int month,
                                                          int day, int hour) {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.DAY_OF_MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, day);
        cal.set(Calendar.HOUR_OF_DAY, 6);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        return cal.getTime();

    }

    /**
     * 获取num天前后，第几点，第几分，第几秒的日期
     *
     * @param
     * @param
     * @return
     */
    public static Date getDateOfAfterDay(int num, int hour, int minute,
                                         int second) {

        Calendar cal = Calendar.getInstance();
        if (num != 0) {
            int day = cal.get(Calendar.DAY_OF_MONTH);
            cal.set(Calendar.DAY_OF_MONTH, day + num);
        }
        if (hour >= 0) {
            cal.set(Calendar.HOUR_OF_DAY, hour);
        }
        if (minute >= 0) {
            cal.set(Calendar.MINUTE, minute);
        }
        if (second >= 0) {
            cal.set(Calendar.SECOND, second);
        }

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // System.out.println(sdf.format(cal.getTime()));
        return cal.getTime();

    }


    /**
     * 获取指定日历num天前后，第几点，第几分，第几秒的日期
     *
     * @param
     * @param
     * @return
     */
    public static Date getDateOfAfterDayByCalendar(Calendar calendar, int num, int hour, int minute,
                                                   int second) {

        if (num != 0) {
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            calendar.set(Calendar.DAY_OF_MONTH, day + num);
        }
        if (hour >= 0) {
            calendar.set(Calendar.HOUR_OF_DAY, hour);
        }
        if (minute >= 0) {
            calendar.set(Calendar.MINUTE, minute);
        }
        if (second >= 0) {
            calendar.set(Calendar.SECOND, second);
        }

        // SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // System.out.println(sdf.format(cal.getTime()));
        return calendar.getTime();

    }

    /**
     * 判断是否是周末
     *
     * @return
     */
    public boolean isWeekend() {
        Calendar cal = Calendar.getInstance();
        int week = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (week == 6 || week == 0) {// 0代表周日，6代表周六
            return true;
        }
        return false;
    }

    /**
     * 获取两个日期之间相差的所有月份
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static List<String> getMonthBetween(String minDate, String maxDate) {
        try {
            ArrayList<String> result = new ArrayList<String>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");// 格式化为年月

            Calendar min = Calendar.getInstance();
            Calendar max = Calendar.getInstance();

            min.setTime(sdf.parse(minDate));
            min.set(min.get(Calendar.YEAR), min.get(Calendar.MONTH), 1);

            max.setTime(sdf.parse(maxDate));
            max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

            Calendar curr = min;
            while (curr.before(max)) {
                result.add(sdf.format(curr.getTime()));
                curr.add(Calendar.MONTH, 1);
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 获取两个日期之间相差天数
     *
     * @param minDate
     * @param maxDate
     * @return
     * @throws ParseException
     */
    public static int getDaysBetween(Date minDate, Date maxDate) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");// 格式化为年月

            minDate = sdf.parse(sdf.format(minDate));
            maxDate = sdf.parse(sdf.format(maxDate));
            int betweenDays = (int) ((maxDate.getTime() - minDate.getTime()) / (1000 * 60 * 60 * 24));
            return betweenDays;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }

    }

    /**
     * 获取当前时间为几点
     *
     * @return
     */
    public static Integer getHour() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.HOUR_OF_DAY);

    }

    /**
     * 获取当前月份
     *
     * @return
     */
    public static Integer getMonth() {
        Calendar cal = Calendar.getInstance();
        return cal.get(Calendar.MONTH);

    }

    /**
     * 日期转字符串
     *
     * @param
     * @param
     * @return
     */
    public static String formatDateToString(Date date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        return sdf.format(date);

    }

    /**
     * 日期转字符串
     *
     * @param
     * @param
     * @return
     */
    public static Date formatStringToDate(String date) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return sdf.parse(date);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return null;
        }

    }

    /**
     * 根据当前日期获取年份月份字符串
     *
     * @param date
     * @return
     */
    public static String getTableNameByDate(Date date, int close) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        SimpleDateFormat format = new SimpleDateFormat("yyyyMM");
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        if (1 == day && hour <= close) {
            cal.add(Calendar.MONTH, -1);
            String time = format.format(cal.getTime());
            return time;
        } else {
            String time = format.format(cal.getTime());
            return time;
        }

    }

    /**
     * 获取本周一6点和周六4点时间
     *
     * @return
     */
    public static Map<String, Date> getDateOfWeekend() {
        Map<String, Date> dateMap = new HashMap<String, Date>();
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_WEEK, 1);
        cal.set(Calendar.HOUR_OF_DAY, 6);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date one = cal.getTime();

        cal.set(Calendar.DAY_OF_WEEK, 6);
        cal.set(Calendar.HOUR_OF_DAY, 4);
        Date six = cal.getTime();
        dateMap.put("one", one);
        dateMap.put("six", six);
        return dateMap;
    }

    // 生成随机数字和字母,
    public static String getStringRandom(int length) {

        String val = "";
        Random random = new Random();

        // 参数length，表示生成几位随机数
        for (int i = 0; i < length; i++) {

            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            // 输出字母还是数字
            if ("char".equalsIgnoreCase(charOrNum)) {
                // 输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char) (random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 生成len位字符串
     *
     * @return
     */
    public static String ranDomString(int len) {
        int[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        Random rand = new Random();
        for (int i = 10; i > 1; i--) {
            int index = rand.nextInt(i);
            int tmp = array[index];
            array[index] = array[i - 1];
            array[i - 1] = tmp;
        }
        String result = "";
        for (int i = 0; i < len; i++) {
            result = result + String.valueOf(array[i]);
        }
        return result;
    }

    /**
     * MD5加密
     *
     * @param content
     * @return
     */
    public static String MD5Encode(String content) {
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(content.getBytes("UTF-8"));
            byte[] encodeData = md5.digest();
            StringBuffer buf = new StringBuffer("");
            for (byte b : encodeData) {
                buf.append(String.format("%02x", b & 0xff));
            }
            return buf.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 请求参数中文解码
     *
     * @param theString
     * @return
     */
    public static String decodeUnicode(String theString) {

        char aChar;
        int len = theString.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = theString.charAt(x++);
            if (aChar == '\\') {
                aChar = theString.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = theString.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }

                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';

                    else if (aChar == 'n')

                        aChar = '\n';

                    else if (aChar == 'f')

                        aChar = '\f';

                    outBuffer.append(aChar);
                }

            } else
                outBuffer.append(aChar);
        }
        return outBuffer.toString();

    }

    /**
     * httpclient包装的httpGet请求
     *
     * @param urlString url地址
     * @return 返回"-1"是失败
     */
    public static String httpGet(String urlString) {

        try {
            return Request.Get(urlString)
                    .connectTimeout(30000)
                    .socketTimeout(30000)
                    .execute().returnContent().asString();
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "-1";
    }


    /**
     * httpclient包装的httpPost请求
     *
     * @param
     * @param
     * @return 返回"-1"是失败
     */
    public static String httpPost(String url, Map<String, Object> parameters) {
        String result = "-1";
        if (parameters != null) {
            try {
                HttpClient httpClient = HttpClientBuilder.create().build();
                HttpPost method = new HttpPost(url);
                List<NameValuePair> params = new ArrayList<NameValuePair>();
                // 建立一个NameValuePair数组，用于存储欲传送的参数
                for (Map.Entry<String, Object> e : parameters.entrySet()) {
                    params.add(new BasicNameValuePair(e.getKey(), e.getValue().toString()));
                }
                // 添加参数
                UrlEncodedFormEntity content = new UrlEncodedFormEntity(params,
                        Consts.UTF_8);
                method.setEntity(content);
                // 设置编码
                HttpResponse response = httpClient.execute(method);
                if (response != null) {
                    HttpEntity resEntity = response.getEntity();
                    if (resEntity != null) {
                        result = EntityUtils.toString(resEntity, Consts.UTF_8);
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return result;
    }


    public static HttpResponse doGet(String host, String path, String method,
                                     Map<String, String> headers,
                                     Map<String, String> querys)
            throws Exception {
        CloseableHttpClient httpClient = HttpClients.createDefault();
//	    	HttpClient httpClient = new DefaultHttpClient();

        HttpGet request = new HttpGet(buildUrl(host, path, querys));
        for (Map.Entry<String, String> e : headers.entrySet()) {
            request.addHeader(e.getKey(), e.getValue());
        }

        return httpClient.execute(request);
    }

    private static String buildUrl(String host, String path, Map<String, String> querys) throws UnsupportedEncodingException {
        StringBuilder sbUrl = new StringBuilder();
        sbUrl.append(host);
        if (!StringUtils.isEmpty(path)) {
            sbUrl.append(path);
        }
        if (null != querys) {
            StringBuilder sbQuery = new StringBuilder();
            for (Map.Entry<String, String> query : querys.entrySet()) {
                if (0 < sbQuery.length()) {
                    sbQuery.append("&");
                }
                if (StringUtils.isEmpty(query.getKey()) && !StringUtils.isEmpty(query.getValue())) {
                    sbQuery.append(query.getValue());
                }
                if (!StringUtils.isEmpty(query.getKey())) {
                    sbQuery.append(query.getKey());
                    if (!StringUtils.isEmpty(query.getValue())) {
                        sbQuery.append("=");
                        sbQuery.append(URLEncoder.encode(query.getValue(), "utf-8"));
                    }
                }
            }
            if (0 < sbQuery.length()) {
                sbUrl.append("?").append(sbQuery);
            }
        }

        return sbUrl.toString();
    }

}
