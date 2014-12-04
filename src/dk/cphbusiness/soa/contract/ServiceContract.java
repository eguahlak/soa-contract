package dk.cphbusiness.soa.contract;

/**
 * This is the super interface for all Services in this SOA
 * simulation.
 * 
 * Services should implement an interface that extends this
 * interface.
 */
public interface ServiceContract {
  /**
   * Whether or not the service supports a given argument.
   * 
   * This method is called by the Register's
   * {@link RegistryContract#lookup(Class, String[])}
   * method. The format of the string is up to the definition
   * of the service.
   * 
   * @param argument The argument to check.
   * @return {@code true} if the service supports the argument.
   */
  boolean supports(String argument);
  /**
   * Priority of the service.
   * 
   * The priority of a service is an integer number between {@code 0}
   * and {@code MAX_VALUE}. Lowest value is the highest priority.
   * It is a good idea to make a {@code MAX_VALUE} priority service,
   * that accepts all arguments.
   * 
   * @return the priority as a number. 
   */
  int getPriority();
  }
