1. config
2. customer model
3. customer repo
3. user details service custom = Bankbackend user details
    - find by username (email)
    - @Override loadUserByUsername = creates userdetails object, to be used by spring security
    - @Service to make it a bean, and override the in-memory user details service
4. customer controller
5. password encoder
    - register Bcrypt password encoder as PasswordEncoder @Bean
6. in controller , hash password before saving to db
7. custom authentication provider (defaulth dao authentication provider)
    - @Bean
    - @Override authenticate
    - @Override supports - authentication manager will call this method to check if this provider can handle the authentication request( is the authentication object of the correct type)
in authentication provider we use userDetailsService to load the user from the db and then compare the password 