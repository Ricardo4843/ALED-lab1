package es.upm.aled.lab1.measurements;

/**
 * Filter that extracts the specified channels from an EEGModel.
 * 
 * @author mmiguel, rgarciacarmona
 *
 */
public class FilterExtractChannels implements Filter {

	/**
	 * Builds the Filter. The use from an array of valid channels.
	 * 
	 * 
	 * @param validChannels The channel numbers to be extracted, starting from 0.
	 */
	private int[] validChannels;

	public FilterExtractChannels(int[] validChannels) {
		this.validChannels = validChannels;
	}

	@Override
	public EEGModel applyFilter(EEGModel eeg) {
		Measurement[] original = eeg.getMeasurements();
		Measurement[] filtradas = new Measurement[original.length];
		for (int i = 0; i < original.length; i++) {
			float[] nuevosCanales = new float[validChannels.length];
			for (int j = 0; j < validChannels.length; j++) {
				nuevosCanales[j] = original[i].getChannel(validChannels[j]);
			}
			filtradas[i] = new Measurement(nuevosCanales);

		}

		return new EEGModel(filtradas);
	}

}
