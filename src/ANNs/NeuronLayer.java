/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ANNs;

public class NeuronLayer
{
    /*La clase NeuronLayer(capa de neuronas) recibe el numero de neuronas que habra
    en esa capa, y crea un arreglo (neuron) de objetos de la clase Neuron, el arreglo
    sera de tamanio igual al numero de neuronas que se le pasa como parametro*/
    NeuronLayer(int i)
    {
        /*cada neurona tiene tres atributos input, output y outputerror, los cuales
        al crear al objeto se inicializan con cero.*/
        neuron = new Neuron[i];
        for(int j = 0; j < i; j++)
            neuron[j] = new Neuron();

    }

    void setInput(Pattern pattern)
    {
        /*Este metodo asigna a los atributos de las neuronas de la capa de entrada,
        (input, output, outputerror) el valor de los patrones de entrada*/
        for(int i = 0; i < neuron.length; i++)
            neuron[i].init(pattern.getValue(i));

    }

    void setInput(InputValue inputvalue)
    {
        float af[] = new float[3];
        af[0] = inputvalue.getX();
        af[1] = inputvalue.getY();
        af[2] = inputvalue.getZ();
        for(int i = 0; i < neuron.length; i++)
            neuron[i].init(af[i]);

    }

    void computeInput(NeuronLayer neuronlayer, WeightMatrix weightmatrix)
    {
        /*Este metodo calcula los valores del atributo input de cada neurona en una capa,
        para eso se llama al metodo computeInput de la clase Neuron la cual recibe, los
        valores de los output de las neuronas de la capa anterior, y los pesos que vienen 
        de esas neuronas hacia las neuronas de esta capa*/
        for(int i = 0; i < neuron.length; i++)
            neuron[i].computeInput(neuronlayer.getOutput(), weightmatrix.getInputWeights(i));

    }

    void computeOutput()
    {
        /*Este metodo calcula los valores del atributo output de cada neurona en una capa*/
        for(int i = 0; i < neuron.length; i++)
            neuron[i].activateSigmoid();

    }

    void computeLayerError(Pattern pattern)
    {
        /*calcula el valor del atributo outputerror para las neuronas de la capa de salida*/
        for(int i = 0; i < neuron.length; i++)
            neuron[i].computeOutputError(pattern.getValue(i));

    }

    void computeLayerError(NeuronLayer neuronlayer, WeightMatrix weightmatrix)
    {
        for(int i = 0; i < neuron.length; i++)
            neuron[i].computeOutputError(neuronlayer.getLayerError(), weightmatrix.getOutputWeights(i));

    }

    float[] getOutput()
    {
        /*Esta funcion retorna un arreglo con los valores del atributo output de cada neurona*/
        float af[] = new float[neuron.length];
        for(int i = 0; i < neuron.length; i++)
            af[i] = neuron[i].getOutput();

        return af;
    }

    float[] getLayerError()
    {
        float af[] = new float[neuron.length];
        for(int i = 0; i < neuron.length; i++)
            af[i] = neuron[i].getOutputError();

        return af;
    }

    int size()
    {
        return neuron.length;
    }
    
    void mostrarAtributos(){
        for(int i = 0; i < neuron.length; i++){
            System.out.println("Neurona input: "+neuron[i].getInput());
            System.out.println("Neurona output: "+neuron[i].getOutput());
            System.out.println("Neurona outputerror: "+neuron[i].getOutputError());
        }        
    }

    Neuron neuron[];
}