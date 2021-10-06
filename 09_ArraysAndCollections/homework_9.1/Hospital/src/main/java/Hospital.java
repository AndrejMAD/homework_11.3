public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {

        //TODO: напишите метод генерации массива температур пациентов

        int minTemperature = 32;
        int maxTemperature = 40;
        float[] patientsTemperatures = new float[patientsCount];

        for (int i = 0; i < patientsTemperatures.length; i++) {
            patientsTemperatures[i] = (float) (Math.random() * ((maxTemperature - minTemperature))) + minTemperature;
        }

        return patientsTemperatures;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */

        String strTemperatures = "";
        float sum = 0;
        int countHealt = 0;

        for (int i = 0; i < temperatureData.length; i++ ) {
            strTemperatures = strTemperatures.concat(String.valueOf(temperatureData[i]));
            sum += temperatureData[i];
            if (temperatureData[i] >= 36.2F && temperatureData[i] <= 36.9F) {
                System.out.println(temperatureData[i]);
                countHealt += 1;
            }
            if (i < temperatureData.length - 1) {
                strTemperatures = strTemperatures.concat(" ");
            }
        }

        float averageTemperature = sum / temperatureData.length;

        String report =
                "Температуры пациентов: " + strTemperatures +
                        "\nСредняя температура: " + String.format("%.2f", averageTemperature) +
                        "\nКоличество здоровых: " + countHealt;

        return report;
    }
}
