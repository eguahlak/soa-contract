package dk.cphbusiness.soa.contract;

/**
 * A very simple interface for a SOA Register simulation.
 * 
 */
public interface RegistryContract {
  /**
   * Register a service in the registry.
   * 
   * A service is defined as a class implementing the 
   * interface {@code <C>} which must extend the
   * {@link ServiceContract} interface.
   * 
   * @param <C> Interface (contract) of the service.
   * @param contract The type of the contract.
   * @param service The service implementing the contract.
   */
  <C extends ServiceContract> void register(
      Class<C> contract, C service
      );
  /**
   * Lookup a service in the registry.
   * 
   * The service must support (see 
   * {@link ServiceContract#supports(String)}) all arguments.
   * If more services are found the service with the highest
   * priority (lowest value from
   * {@link ServiceContract#getPriority()}) is chosen.
   * 
   * @param <C> Interface (contract) of the service.
   * @param contract The type of the contract.
   * @param arguments The arguments that must match.
   * @return The found service with the highest priority.
   * @throws NoMatchingServiceException When no 
   * matching service is found.
   */
  <C extends ServiceContract> C lookup(
      Class<C> contract, String... arguments
      ) throws NoMatchingServiceException;
  }
